package com.mrkek.junit.service;

import com.mrkek.junit.dto.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductServiceTest {

    /*
    Verify adding a product that already exists in inventory.
    Verify adding a new product.
    Verify removing a product when sufficient quantity is available.
    Verify exception handling when insufficient product is available for removal.
    */

    private ProductService productService;

    private static final Product PRODUCT_APPLE = Product.of("apple", 1);

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void verifyAddingExistingProductToInventory() {
        var firstProduct = productService.addProduct(PRODUCT_APPLE);
        var secondProduct = productService.addProduct(PRODUCT_APPLE);
        assertTrue(firstProduct);
        assertFalse(secondProduct);
    }

    @Test
    void verifyAddingNewProductToInventory() {
        var isAdded = productService.addProduct(PRODUCT_APPLE);
        assertTrue(isAdded);
    }

    @Test
    void verifyRemovingProductWithSufficientQuantity() {
        productService.addProduct(PRODUCT_APPLE);
        assertTrue(productService.removeProduct(PRODUCT_APPLE, 1));
    }

    @Test
    void verifyExceptionHandlingForInsufficientProductRemoval() {
        productService.addProduct(PRODUCT_APPLE);
        assertFalse(productService.removeProduct(PRODUCT_APPLE, 4));
    }
}
