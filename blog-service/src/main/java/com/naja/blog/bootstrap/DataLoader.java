package com.naja.blog.bootstrap;

import com.naja.blog.model.Category;
import com.naja.blog.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DataLoader( CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {


            Category general = new Category("General");
            Category java = new Category("Java");
            categoryRepository.save(general);
            categoryRepository.save(java);
        }

    }

