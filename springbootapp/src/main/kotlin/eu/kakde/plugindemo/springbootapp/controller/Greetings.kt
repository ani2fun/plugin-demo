package eu.kakde.plugindemo.springbootapp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Greetings {

    @GetMapping("/greet")
    fun hello(): String {
        return "Hello, World!"
    }
}