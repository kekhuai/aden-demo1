package com.ascendcommerce.aden.demo.person;

import java.util.List;
import java.util.Optional;

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
    public Person wholeUpdatePerson(Long id, PersonDto dto) {
        Optional<Person> optionalPerson = repo.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new RuntimeException("Person id was not found");
        }
        Person person = optionalPerson.get();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setNickname(dto.getNickname());

        return repo.save(person);
    }

    @Override
    public Person partialUpdatePerson(Long id, PersonDto dto) {
        Optional<Person> optionalPerson = repo.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new RuntimeException("Person id was not found");
        }
        Person person = optionalPerson.get();
        if (null != dto.getFirstName()) {
            person.setFirstName(dto.getFirstName());
        }
        if (null != dto.getLastName()) {
            person.setLastName(dto.getLastName());
        }
        if (null != dto.getNickname()) {
            person.setNickname(dto.getNickname());
        }

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

}
