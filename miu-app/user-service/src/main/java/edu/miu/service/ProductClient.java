package edu.miu.service;

import edu.miu.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name="PRODUCT-SERVICE", url="http://localhost:8085")
@FeignClient("PRODUCT-SERVICE")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductDto> getAllProducts();
}
