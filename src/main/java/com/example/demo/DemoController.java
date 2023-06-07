package com.example.demo;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "*", maxAge = 1800)
@RestController
@RequestMapping(value ="/api/demo", produces = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaTypes.HAL_JSON_VALUE
})
public class DemoController {

    private static final String APPLICATION_V1_UTF8_VALUE = "application/helloworld.v1+json;charset=UTF-8";
    private static final String APPLICATION_V2_UTF8_VALUE = "application/helloworld.v2+json;charset=UTF-8";

    @GetMapping(produces = APPLICATION_V1_UTF8_VALUE)
    public ResponseEntity<?> getV1() {
        return ok().body("Hello V1");
    }

    @GetMapping(produces = APPLICATION_V2_UTF8_VALUE)
    public ResponseEntity<?> getV2() {
        return ok().body("Hello V2");
    }
}
