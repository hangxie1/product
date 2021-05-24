package com.cvshealth.xplab.sample.controller;

import com.cvshealth.xplab.sample.model.ProductDTO;
import com.cvshealth.xplab.sample.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    List<ProductDTO> getAllProduct()  {
        return productService.getAllProduct();
    }


    @GetMapping("/product/{productId}")
    ProductDTO getProdcut(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/product")
    void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);

    }
}
