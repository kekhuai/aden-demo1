package com.ascendcommerce.aden.demo.person;

import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

import org.springframework.stereotype.Service;

import com.ascendcommerce.aden.demo.person.dto.PersonDto;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repo;

    public PersonServiceImpl(PersonRepository repo) {
        this.repo = repo;
    }

    @Override
    public Person createPerson(PersonDto dto) {
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setNickname(dto.getNickname());

        return repo.save(person);
    }

    @Override
    public List<Person> getPeople() {
        return repo.findAll();
    }

    @Override
    public void deletePerson(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Person update(Long id, UnaryOperator<Person> func) {
        Optional<Person> optionalPerson = repo.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new RuntimeException("Person id was not found");
        }
        Person person = optionalPerson.get();
        person = func.apply(person);
        return repo.save(person);
    }

}
