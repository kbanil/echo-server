package com.daas.echoserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@RestController
@RequestMapping("/v1")
@Slf4j
public class EchoServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EchoServerApplication.class, args);
  }

  @GetMapping(path = "/echo/{message}", produces = APPLICATION_JSON_VALUE)
  public Map<String, String> echo(@PathVariable String message) {
    String greetings = "Echo from DaaS 360: ";
    String echoMessage = greetings + message;
    return singletonMap("message", echoMessage);
  }
}
