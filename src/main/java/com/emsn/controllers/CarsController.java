package com.emsn.controllers;

import com.emsn.models.Car;
import com.emsn.models.Person;
import com.emsn.repositories.CarRepository;
import com.emsn.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping({"/cars"})
public class CarsController {
    private CarRepository repo;

    @Autowired
    public void setRepo(CarRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Car> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        PageRequest pr = new PageRequest(page, 3);
        return repo.findAll(pr);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Car show(@PathVariable int id){
        return repo.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Car create(@RequestBody Car car) {
        return repo.save(car);
    }
}