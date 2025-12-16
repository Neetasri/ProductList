package com.example.Product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Product Servoce REST API documentation",
                description = "Product Service Rest API",
                version = "v1",
                contact = @Contact(
                        name = "Neeta",
                        email = "neeta.kumari018@gmail.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "SharePoint URl for Product Service API",
                url="example.com"
        )
)

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
