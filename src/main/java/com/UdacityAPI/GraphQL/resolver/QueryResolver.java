package com.UdacityAPI.GraphQL.resolver;

import com.UdacityAPI.GraphQL.entity.Dog;
import com.UdacityAPI.GraphQL.repository.DogRepository;
import com.UdacityAPI.GraphQL.exception.DogNotFoundException;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.Optional;

public class QueryResolver implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public QueryResolver(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
