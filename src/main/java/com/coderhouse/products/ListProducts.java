package com.coderhouse.products;

import com.coderhouse.products.handle.ApiRestException;
import com.coderhouse.products.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ListProducts {

    private List<Product> products;
    private Long counter;

    public ListProducts(){
        this.products = new ArrayList<Product>();
        this.counter = 0L;
    }

    public List<Product> getData(){
        return this.products;
    }

    public Product getData(Long id) throws ApiRestException{
        Product product = this.products.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ApiRestException("error: producto no encontrado"));

        return product;
    }

    public void addProduct(Product product){
        this.counter++;
        product.setId(counter);
        this.products.add(product);
    }
}
