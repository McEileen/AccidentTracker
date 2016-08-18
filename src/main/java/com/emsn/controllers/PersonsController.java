package com.emsn.controllers;

import com.emsn.models.Car;
import com.emsn.models.Person;
import com.emsn.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/persons"})
public class PersonsController {
    private PersonRepository repo;

    @Autowired
    public void setRepo(PersonRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Person> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        PageRequest pr = new PageRequest(page, 3);
        return repo.findAll(pr);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person show(@PathVariable int id){
        return repo.findOne(id);
    }

//    //show all cars associated with a specific person
//    @RequestMapping(path = "/{id}/cars", method = RequestMethod.GET)
//    public List<Car> showCars(@PathVariable int id){
//        Person person = repo.findOne(id);
//        return person.getCars();
//    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        return repo.save(person);
    }
}