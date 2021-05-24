package com.cvshealth.xplab.sample.services;

import com.cvshealth.xplab.sample.entities.ProductEntity;
import com.cvshealth.xplab.sample.model.ProductDTO;
import com.cvshealth.xplab.sample.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    ModelMapper modelMapper;

    public  ProductService(ProductRepository productRepository){
        modelMapper = new ModelMapper();
        this.productRepository = productRepository;
    }
    public void addProduct(ProductDTO  productDTO) {
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        productRepository.save(productEntity);
    }

    public ProductDTO getProduct(Long productId) {
        ProductEntity productEntity =  productRepository.findById(productId).get();
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    public List<ProductDTO> getAllProduct(){
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (ProductEntity  productEntity: productRepository.findAll()) {
            ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }
}
