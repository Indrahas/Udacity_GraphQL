package com.UdacityAPI.GraphQL.repository;

import com.UdacityAPI.GraphQL.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog,Long> {
}
