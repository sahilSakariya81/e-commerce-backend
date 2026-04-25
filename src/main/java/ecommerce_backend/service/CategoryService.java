package ecommerce_backend.service;

import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.CategoryTable;
import ecommerce_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ResponseDTO addCategory(CategoryTable ct){
        categoryRepository.save(ct);
        return new ResponseDTO("Category Added Successfully" , HttpStatus.OK);
    }
}
