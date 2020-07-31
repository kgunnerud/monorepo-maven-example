package com.github.kgunnerud.example.apps.foo;

import com.github.kgunnerud.example.libs.contracts.json.foo.FooDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication
public class FooApp {
    public static void main(String[] args) {
        SpringApplication.run(FooApp.class, args);
    }

    @GetMapping("foo")
    FooDto foo() {

        return new FooDto("A Name");
    }
}
