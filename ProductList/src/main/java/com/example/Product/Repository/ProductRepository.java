package com.example.Product.Repository;

import com.example.Product.Entity.Product;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
