/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.Category;
import Springweb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author trinh_hoang_phu
 */
public class CategoryService implements ServiceItf{

    @Autowired
    public CategoryRepository categoryRepository;
    
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
    
}
