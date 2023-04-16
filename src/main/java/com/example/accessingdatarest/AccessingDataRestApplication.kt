package com.example.accessingdatarest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class AccessingDataRestApplication

fun main(args: Array<String>) {
    SpringApplication.run(AccessingDataRestApplication::class.java, *args)
}