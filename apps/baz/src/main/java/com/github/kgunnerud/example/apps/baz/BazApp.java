package com.github.kgunnerud.example.apps.baz;

import com.github.kgunnerud.example.libs.contracts.json.baz.BazDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication
public class BazApp {
    public static void main(String[] args) {
        SpringApplication.run(BazApp.class, args);
    }

    @GetMapping("baz")
    BazDto baz() {

        return new BazDto(Long.MAX_VALUE);
    }
}
