package com.tej;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.base.process.GqlSchemaGenerator.generateTypes;

@SpringBootApplication
public class SpringGQLApplication {

    public static void main(String[] args) {
        generateTypes();
        SpringApplication.run(SpringGQLApplication.class, args);


    }
}
