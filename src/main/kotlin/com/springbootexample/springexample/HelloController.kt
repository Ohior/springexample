package com.springbootexample.springexample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//so that it can handle rest request
//endpoint to listen to
@RestController
@RequestMapping("api/hello")
class HelloController {
//    add mapping
    @GetMapping
    fun helloWorld():String = "Hello REST End point"
}