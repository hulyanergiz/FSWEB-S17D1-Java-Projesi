package com.workintech.s17g1.utils;

import com.workintech.s17g1.entity.Animal;

public class ValidationUtils {
    public static void checkId(Integer id){
        if(id==null||id<0){
            System.out.println("id cannot be null or less than zero");
        }
    }
    public static void checkAnimal(Animal animal){
        if(animal.getId()==null||animal.getName().isEmpty()){
            System.out.println("animal id cannot be null or empty");
        }

    }
}
