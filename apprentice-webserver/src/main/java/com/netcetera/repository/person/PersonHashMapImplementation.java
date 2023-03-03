package com.netcetera.repository.person;

import com.netcetera.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@ConditionalOnProperty(prefix = "app", name = "storageType", havingValue = "MAP")
@AllArgsConstructor
public class PersonHashMapImplementation implements PersonRepository {

  private Map<Long, Person> personMap;

  @Override
  public List<Person> getAll() {
    // TODO: Check out Java streams here: https://www.baeldung.com/java-8-streams
    return personMap.values().stream().toList();
  }

  @Override
  public Person findPersonById(Long id) {
    return personMap.get(id);
  }

  @Override
  public Person storePerson(Person person) {
    personMap.put(person.getId(), person);
    return person;
  }
}
