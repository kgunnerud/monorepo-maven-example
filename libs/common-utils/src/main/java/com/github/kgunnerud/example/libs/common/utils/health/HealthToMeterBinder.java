package com.github.kgunnerud.example.libs.common.utils.health;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.HealthContributorRegistry;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

import java.util.function.ToDoubleFunction;

@RequiredArgsConstructor
public class HealthToMeterBinder implements MeterBinder {
    private final HealthContributorRegistry registry;

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        registry.stream()
                .filter(e -> e.getContributor() instanceof HealthIndicator)
                .forEach(e -> bind(e.getName(), (HealthIndicator) e.getContributor(), meterRegistry));
    }

    private void bind(String key, HealthIndicator healthIndicator, MeterRegistry registry) {
        Gauge.builder("health", healthIndicator, statusToDouble()).tag("name", key).register(registry);
    }

    private ToDoubleFunction<HealthIndicator> statusToDouble() {
        return value -> {
            var status = value.health().getStatus().getCode();
            if (Status.UP.equals(status)) {
                return 1;
            } else if (Status.DOWN.equals(status)) {
                return 2;
            } else if (Status.OUT_OF_SERVICE.equals(status)) {
                return 3;
            } else {
                return 4;
            }
        };
    }
}
