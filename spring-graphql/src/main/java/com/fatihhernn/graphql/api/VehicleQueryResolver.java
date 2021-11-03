package com.fatihhernn.graphql.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.fatihhernn.graphql.entity.Vehicle;
import com.fatihhernn.graphql.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//get, getById, getByPagination gibi islemler olacak
@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {


    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(String type){
        return vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id){
        return vehicleRepository.findById(id);
    }
}
