package com.tej.controllers;

import com.tej.gqlservices.SchemaWiringServiceImpl;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringGQLController {

    @Autowired
    private SchemaWiringServiceImpl schemaWiringService;

    @RequestMapping(value = "/instructor", method = RequestMethod.POST)
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult result = schemaWiringService.executeQuery(query);
        return ResponseEntity.ok(result.getData());

    }
}
