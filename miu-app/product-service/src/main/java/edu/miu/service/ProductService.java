package edu.miu.service;

import edu.miu.entity.Product;

public interface ProductService {

    Iterable<Product> getAll();

    Product getById(int id);
}
