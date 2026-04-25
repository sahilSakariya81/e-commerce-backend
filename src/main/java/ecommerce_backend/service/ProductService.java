package ecommerce_backend.service;

import ecommerce_backend.DTO.ProductRequestDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.CategoryTable;
import ecommerce_backend.model.ProductTable;
import ecommerce_backend.repository.CategoryRepository;
import ecommerce_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ResponseDTO addProduct(ProductRequestDTO dto){

        // Fetch category from DB
        CategoryTable category = categoryRepository
                .findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Calculate current price
        double currentPrice = dto.getPrice() - (dto.getPrice() * dto.getDiscount() / 100);

        // Create product object using constructor
        ProductTable product = new ProductTable(
                dto.getProductName(),
                dto.getPrice(),
                dto.getDiscount(),
                currentPrice,
                dto.getStock(),
                dto.getDescription(),
                category
        );

        // Save product
        productRepository.save(product);

        return new ResponseDTO("Product added successfully", HttpStatus.OK);
    }
}
