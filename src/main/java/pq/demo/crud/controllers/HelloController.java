package pq.demo.crud.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping("say")
    public String sayHello(String name) {
        log.info("Hello"+name);
        return "Hello"+name;
    }
}
