package com.zookeper.zookeper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
    @Autowired
    AnimalRepository AnimalRepository;
    
    @GetMapping("/animals")
    public List<Animal> getAllAnimals(){
    return AnimalRepository.findAll();
    }

    @GetMapping("/animals/{id}")
    public Animal getSingleAnimal(@PathVariable Integer id) {
        Animal animal = AnimalRepository.findById(id).get();
        return animal;
    }

    @PostMapping("/animals")
    public Animal createAnimal(@RequestBody Animal newanimal){
        Animal animal= AnimalRepository.save(newanimal);
        return animal;
    }

    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        AnimalRepository.deleteById(id);
        return "Animal deleted succesfuly";
    }

    @PatchMapping("/animals/{id}")
    public Animal updateAnimal(@RequestBody Animal animal, @PathVariable int id) {
        animal.id=id;
        return AnimalRepository.save(animal);
    }
    
}


interface AnimalRepository extends JpaRepository<Animal, Integer>{}
