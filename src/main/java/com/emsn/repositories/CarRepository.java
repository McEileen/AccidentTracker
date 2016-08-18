package com.emsn.repositories;

import com.emsn.models.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Integer> {
}