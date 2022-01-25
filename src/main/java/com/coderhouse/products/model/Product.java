package com.coderhouse.products.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor(staticName = "of")
public class Product {

    private Long id;
    private String title;
    private String price;

}
