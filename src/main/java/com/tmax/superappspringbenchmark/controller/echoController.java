package com.tmax.superappspringbenchmark.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/echo")
public class echoController {

    @GetMapping
    public String get(@RequestParam("msg") String msg) throws InterruptedException{
        System.out.println("Incoming GET MSG : " + msg);
        Thread.sleep(300);
        return msg;
    }

    @PostMapping
    public String post(@RequestBody String msg) throws InterruptedException{
        System.out.println("Incoming POST MSG : " + msg);
        Thread.sleep(300);
        return msg;
    }
}
