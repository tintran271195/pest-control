package com.example.pestcontrol.repository;

import com.example.pestcontrol.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
