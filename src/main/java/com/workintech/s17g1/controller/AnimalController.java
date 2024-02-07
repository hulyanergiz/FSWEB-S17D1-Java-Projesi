package com.workintech.s17g1.controller;

import com.workintech.s17g1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void init(){
        animals=new HashMap<>();
        animals.put(1,new Animal(1,"dog"));
    }
    @GetMapping
    public List<Animal> getAnimal(){
        return new ArrayList<>((this.animals.values()));
    }
    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") Integer id){
        return animals.get(id);
    }
    @PostMapping
    public void addAnimal(@RequestBody Animal animal){
        this.animals.put(animal.getId(),animal);
    }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable("id") Integer existingRecordId,@RequestBody Animal newAnimal){
        this.animals.replace(existingRecordId,newAnimal);
        return this.animals.get(existingRecordId);
    }
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable("id") Integer id){
        this.animals.remove(id);
    }
}
