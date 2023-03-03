package com.netcetera.repository.person;

import com.netcetera.model.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;

/**
 * In memory storage with an array list.
 */
@Repository
@ConditionalOnProperty(prefix = "app", name = "storageType", havingValue = "ARRAY")
public class PersonRepositoryArrayListImpl implements PersonRepository {

  private final ArrayList<Person> personList = new ArrayList<>();

  @Override
  public ArrayList<Person> getAll() {
    return personList;
  }

  @Override
  public Person findPersonById(Long id) {
    for (Person person : personList) {
      if (Objects.equals(person.getId(), id)) {
        return person;
      }
    }
    return null;
  }

  @Override
  public Person storePerson(Person person) {
    // This id is only added so queries towards the array list implementation also work
    person.setId(personList.size() + 1L);
    personList.add(person);
    return person;
  }
}
