package com.phexample.simpeapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository <Customer, Long> {

  //  List<Customer> findByUsername(@Param("username") String username);

}
