package com.ascendcommerce.aden.demo.person;

import java.util.List;
import java.util.function.UnaryOperator;

import com.ascendcommerce.aden.demo.person.dto.PersonDto;

public interface PersonService {

    Person createPerson(PersonDto dto);

    List<Person> getPeople();

    void deletePerson(Long id);
    
    Person update(Long id, UnaryOperator<Person> person);
}
