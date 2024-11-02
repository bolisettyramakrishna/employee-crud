package example_temp.springboot_temp.controller;


import example_temp.springboot_temp.entity.Product;
import example_temp.springboot_temp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;
    @PostMapping("/create-product")
    public Product createProduct(@RequestBody Product product){

        productRepo.save(product);
        return product;
    }

    @GetMapping("/get-products")
    public List<Product> getProducts(){

        return productRepo.findAll();
    }

}
