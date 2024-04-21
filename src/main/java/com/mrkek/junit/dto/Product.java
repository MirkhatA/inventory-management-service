package com.mrkek.junit.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class Product {

    String name;
    int quantity;
}
