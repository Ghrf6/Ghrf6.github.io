package com.netcetera.service;

import com.netcetera.model.Person;
import com.netcetera.repository.person.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to help with the handling of persons.
 * Storage, fetching is already implemented.
 * <p>
 * -> Can contain sorting, filtering methods or other service calls.
 */
@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person storePerson(Person person) {
        return personRepository.storePerson(person);
    }

  public List<Person> getPersonList() {
    return personRepository.getAll();
  }

    public Person findPersonById(Long id) {
        return personRepository.findPersonById(id);
    }

    public Person storeParent(Person person) {
        person.setParent(true);
        return storePerson(person);
    }

    public Person storeChild(Person person) {
        person.setParent(false);
        if (person.getMotherId() != null){
            person.setMother(findPersonById(person.getMotherId()));
        }
        if(person.getFatherId() != null){
            person.setFather(findPersonById(person.getFatherId()));
        }
        return storePerson(person);
    }
}
