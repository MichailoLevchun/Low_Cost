package com.Low_Cost.dto;

import com.Low_Cost.entity.Shirt;

/**
 * Created by Study on 30.06.2017.
 */
public class DtoUtilMapper {

    public static  ShirtDto shirtToShirtDto(Shirt shirt){

        return new ShirtDto(shirt.getId(),shirt.getShirtName(),shirt.getPathImage());
    }

}
