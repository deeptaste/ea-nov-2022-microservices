package edu.miu.controller;

import edu.miu.entity.Product;
import edu.miu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
@RefreshScope
public class ProductController {

    public final ProductService productService;

    @GetMapping
    public Iterable<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @Value("${ping.message}")
    private String message;

    @GetMapping("/ping")
    public String getConfigMessage() {
        return message;
    }

}
