package com.ascendcommerce.aden.demo.person;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ascendcommerce.aden.demo.person.dto.PersonDto;

@RestController
@RequestMapping(path = "/api/v1/people")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        super();
        this.service = service;
    }

    @PostMapping
    public Person create(@RequestBody PersonDto dto) {
        return service.createPerson(dto);
    }

    @GetMapping
    public List<Person> get() {
        return service.getPeople();
    }

    @PutMapping(path = "/{id}")
    public Person wholeUpdate(@PathVariable Long id, @RequestBody PersonDto dto) {
        return service.update(id, person -> {
            person.setFirstName(dto.getFirstName());
            person.setLastName(dto.getLastName());
            person.setNickname(dto.getNickname());
            return person;
        });
    }

    @PatchMapping(path = "/{id}")
    public Person partialUpdate(@PathVariable Long id, @RequestBody PersonDto dto) {
        return service.update(id, person -> {
            if (null != dto.getFirstName()) {
                person.setFirstName(dto.getFirstName());
            }
            if (null != dto.getLastName()) {
                person.setLastName(dto.getLastName());
            }
            if (null != dto.getNickname()) {
                person.setNickname(dto.getNickname());
            }
            return person;
        });
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        service.deletePerson(id);
    }
}
