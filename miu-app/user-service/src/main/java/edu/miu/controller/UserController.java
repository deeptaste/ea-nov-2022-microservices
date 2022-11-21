package edu.miu.controller;

import edu.miu.dto.ProductDto;
import edu.miu.entity.User;
import edu.miu.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
@RefreshScope
public class UserController {

    public final UserService userService;

    private final RestTemplate restTemplate;

    @GetMapping
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @CircuitBreaker(name="productFallback", fallbackMethod = "productFallbackMethod")
    @GetMapping("/{id}/products")
    public Iterable<User> getAllUserProducts(@PathVariable int id) {
        var result = restTemplate.getForObject("http://product-service/products/1", ProductDto.class);
        System.out.println(result);

        return userService.getAll();
    }

    public Iterable<User> productFallbackMethod(Exception e) {
        User dummyData = new User();
        dummyData.setId(1);
        dummyData.setAge(1);
        dummyData.setName("This is a dummy Data");
        List<User> dummy = Arrays.asList(dummyData);
        Iterable<User> dummyIterable = dummy;

        return  dummyIterable;
    }

    @Value("${ping.message}")
    private String message;

    @GetMapping("/ping")
    public String getConfigMessage() {
        return message;
    }

}
