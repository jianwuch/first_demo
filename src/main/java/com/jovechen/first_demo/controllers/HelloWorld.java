package com.jovechen.first_demo.controllers;

import com.jovechen.first_demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class HelloWorld {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map helloWorld() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("data", new User("12345", "HelloWorld", 0));
        ret.put("code", "200");
        ret.put("msg", "成功");
        return ret;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Map getUserById(@RequestParam String id) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("data", new User(id, "HelloWorld", 0));
        ret.put("code", "200");
        ret.put("msg", "成功");
        System.out.print(Thread.currentThread().getName()+"线程");
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        System.out.println(name);
        return ret;
    }
}
