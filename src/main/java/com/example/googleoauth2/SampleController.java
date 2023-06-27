package com.example.googleoauth2;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class SampleController {

    @GetMapping
    public ResponseEntity<String> introduction() {
        return ResponseEntity.ok().body("Welcome to test API");
    }

    @GetMapping("/secured")
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().body("api is healthy");
    }
}
