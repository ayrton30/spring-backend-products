package com.coderhouse.products.controller;

import com.coderhouse.products.ListProducts;
import com.coderhouse.products.handle.ApiRestException;
import com.coderhouse.products.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductsController {

    @Autowired
    ListProducts products;
    Logger logger = LogManager.getLogger(ProductsController.class);

    //A. Listar en forma total
    @GetMapping
    public List<Product> getProductsAll() throws ApiRestException {
        logger.info("GET Request getProductsAll()");
        if(products.getData().size() == 0){
            throw new ApiRestException("error: no hay productos cargados");
        }
        return products.getData();
    }

    //B. Listar en forma individual
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) throws ApiRestException{
        logger.info("GET Request getProduct(id)");
        return products.getData(id);
    }

    //C. Almacenar un producto
    @PostMapping
    public Product addProduct(@RequestBody Product newProduct){
        logger.info("POST Request addProduct()");
        products.addProduct(newProduct);
        return products.getData().get(products.getData().size()-1);
    }



}
