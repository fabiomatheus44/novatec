package com.pruebaTecnica.novatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaTecnica.novatec.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, String> {

}
