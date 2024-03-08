package com.ozzyjpa.demojpa.repository;

import com.ozzyjpa.demojpa.entities.Product;
import com.ozzyjpa.demojpa.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProductRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Product save(Product product){
        if(product.getId() == null){ // insert
            entityManager.persist(product);
        }
        else { // update
            entityManager.merge(product);
        }
        return product;
    }
}
