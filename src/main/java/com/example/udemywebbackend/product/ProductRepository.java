package com.example.udemywebbackend.product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Integer>{

    Product findByName(String name);

    @Query("UPDATE Product p SET p.enabled= ?2 WHERE p.id=?1")
    @Modifying
    void updateStatus(int id,boolean status);

    Long countById(int id);
}
