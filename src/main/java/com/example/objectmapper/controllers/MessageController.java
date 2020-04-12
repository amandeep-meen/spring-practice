package com.example.objectmapper.controllers;

import com.example.objectmapper.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    @GetMapping(path = "/hello/{from}/{to}")
    public ResponseEntity<Message> sayHello(@PathVariable(name = "from", required = true) String from,
                                            @PathVariable(name = "to", required = true) String to) {
        UserDetailsServiceAutoConfiguration f;
        Message message = Message.builder()
                .from(from)
                .to(to)
                .message(String.format("Hi %s, from %s", to, from))
                .build();
        return ResponseEntity.ok(message);
    }

}
