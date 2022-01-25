package com.coderhouse.products;

import com.coderhouse.products.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ProductsApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public CommandLineRunner loadData(ListProducts repository) {
		return (args) -> {
			repository.addProduct(
					Product.builder()
							.title("productoTitle1")
							.price("5000")
							.build()
			);
			repository.addProduct(
					Product.builder()
							.title("productoTitle2")
							.price("3000")
							.build()
			);
		};
	}

}
