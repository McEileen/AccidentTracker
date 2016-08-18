package com.emsn.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.emsn.models.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
}