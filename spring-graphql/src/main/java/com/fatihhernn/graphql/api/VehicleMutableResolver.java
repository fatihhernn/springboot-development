package com.fatihhernn.graphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.fatihhernn.graphql.dto.VehicleDto;
import com.fatihhernn.graphql.entity.Vehicle;
import com.fatihhernn.graphql.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

//save update gibi islemler yapılacak
@Component
@RequiredArgsConstructor
public class VehicleMutableResolver implements GraphQLMutationResolver {


    private  final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto){
        return vehicleRepository.save(dtoToEntity(vehicleDto));
    }

    private Vehicle dtoToEntity(VehicleDto vehicleDto){
        Vehicle vehicle=new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setLaunchDate(new Date());
        vehicle.setType(vehicleDto.getType());
        return vehicle;
    }

}
