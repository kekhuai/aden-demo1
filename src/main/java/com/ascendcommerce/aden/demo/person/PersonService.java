package com.ascendcommerce.aden.demo.person;

import java.util.List;

import com.ascendcommerce.aden.demo.person.dto.PersonDto;

public interface PersonService {

    Person createPerson(PersonDto dto);

    Person wholeUpdatePerson(Long id, PersonDto dto);

    Person partialUpdatePerson(Long id, PersonDto dto);

    List<Person> getPeople();

    void deletePerson(Long id);
}
