package com.tmax.superappspringbenchmark.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tmax.superappspringbenchmark.ThreadTracker;



@RestController
@RequestMapping("/echo")
public class echoController {
    @Autowired
    private Environment env;
    
    @Autowired
    private ThreadTracker threadTracker;

    @GetMapping
    public String get(@RequestParam("msg") String msg) throws InterruptedException {
        Thread.sleep(Integer.parseInt(env.getProperty("server.benchmark.sleep-time")));
        long threadId = Thread.currentThread().getId();
        threadTracker.addThreadId(threadId);
        System.out.println("Incoming GET MSG : " + msg + " on thread number: " + threadId);
        System.out.println("How many threads did we use? : " + String.valueOf(threadTracker.getTotalThreadsUsed()));
        return msg;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Message message) throws InterruptedException {
        String msg = message.getMsg();
        Map<String, Object> response = new HashMap<>();
        response.put("msg", msg);
        
        Thread.sleep(Integer.parseInt(env.getProperty("server.benchmark.sleep-time")));
        long threadId = Thread.currentThread().getId();
        threadTracker.addThreadId(threadId);
        System.out.println("Incoming POST MSG : " + msg + " on thread number: " + threadId);
        response.put("threadId", threadId);
        System.out.println("How many threads did we use? : " + String.valueOf(threadTracker.getTotalThreadsUsed()));
        return ResponseEntity.ok(response);
    }
}
