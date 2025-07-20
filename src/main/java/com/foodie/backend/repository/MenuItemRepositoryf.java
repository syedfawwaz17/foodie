package com.foodie.backend.repository;

import com.foodie.backend.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemRepositoryf extends MongoRepository<Menu,String> {
}

