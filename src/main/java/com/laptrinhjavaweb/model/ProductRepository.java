package com.laptrinhjavaweb.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Flowers, String> {
    List<Flowers> findByNameContaining(String q);
}