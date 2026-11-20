package com.example.gatepass;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "GatePass API",
                version = "1.0",
                description = "API RESTful para controle e registro de visitas na portaria."
        )
)
@SpringBootApplication
public class GatePassApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatePassApplication.class, args);
    }
}
