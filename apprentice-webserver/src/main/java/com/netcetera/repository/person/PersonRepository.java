package com.netcetera.repository.person;

import com.netcetera.model.Person;

import java.util.List;

/**
 * Repository is used to access the storage part of the application.
 * <p>
 * Usually a Database connection is expected to be found behind the implementations.
 */
public interface PersonRepository {

  /**
   * Returns all stored persons.
   *
   * @return the list of all persons.
   */
  List<Person> getAll();

  /**
   * Get one specific person.
   *
   * @return the person with the matching id.
   */
  Person findPersonById(Long id);

  /**
   * Store one person.
   *
   * @param person the person to store
   * @return the person that has been stored
   */
  Person storePerson(Person person);

//  Person findPersonById(Long long);
}
