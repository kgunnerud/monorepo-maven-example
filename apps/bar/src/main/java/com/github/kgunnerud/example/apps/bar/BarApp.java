package com.github.kgunnerud.example.apps.bar;

import com.github.kgunnerud.example.libs.contracts.json.bar.BarDto;
import com.github.kgunnerud.example.libs.contracts.json.foo.FooDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping
@SpringBootApplication
public class BarApp {
    public static void main(String[] args) {
        SpringApplication.run(BarApp.class, args);
    }

    @GetMapping("bar")
    BarDto bar() {
        return new BarDto(UUID.randomUUID().toString());
    }

    @GetMapping("fooByProxy")
    FooDto foo() {
        var restTemplate = new RestTemplate(); // Yes, should be a bean.

        return restTemplate.getForObject("http://localhost:8082/foo", FooDto.class);
    }
}
