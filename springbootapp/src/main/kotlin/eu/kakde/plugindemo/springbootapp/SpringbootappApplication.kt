package eu.kakde.plugindemo.springbootapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootappApplication

fun main(args: Array<String>) {
	runApplication<SpringbootappApplication>(*args)
}

