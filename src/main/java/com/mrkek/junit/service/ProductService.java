package com.mrkek.junit.service;

import com.mrkek.junit.dto.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductService {

    private final List<Product> products = new LinkedList<>();

    public boolean addProduct(Product product) {
        if (products.contains(product)) {
            return false;
        }
        products.add(product);
        return true;
    }

    public boolean removeProduct(Product product, int quantity) {
        if (products.contains(product)) {
            if (product.getQuantity() >= quantity) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}
