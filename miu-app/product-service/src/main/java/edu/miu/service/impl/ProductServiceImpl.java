package edu.miu.service.impl;

import edu.miu.entity.Product;
import edu.miu.repo.ProductRepo;
import edu.miu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    public final ProductRepo productRepo;

    @Override
    public Iterable<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).get();
    }
}
