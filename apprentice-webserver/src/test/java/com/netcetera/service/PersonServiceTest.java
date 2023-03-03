//package com.netcetera.service;
//
//import com.netcetera.model.Person;
//import com.netcetera.repository.person.PersonRepository;
//import com.netcetera.repository.person.PersonRepositoryArrayListImpl;
//import org.junit.jupiter.api.Test;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PersonServiceTest {
//
//
//    PersonRepository personRepository = new PersonRepositoryArrayListImpl();
//    PersonService personService = new PersonService(personRepository);
//
//    @Test
//    public void shouldStoreChildWithBothParent() {
//        Person father = new Person();
//        Person mother = new Person();
//        Person child = new Person();
//
//        father.setId(UUID.randomUUID());
//        mother.setId(UUID.randomUUID());
//        personRepository.storePerson(father);
//        personRepository.storePerson(mother);
//        child.setId(UUID.randomUUID());
//        child.setFatherId(father.getId());
//        child.setMotherId(mother.getId());
//        personService.storeChild(child);
//        assertNotNull(child.getFather());
//        assertNotNull(child.getMother());
//        int countAllPersons = personRepository.getAll().size();
//        assertEquals(3, countAllPersons);
//    }
//
//    @Test
//    public void shouldStoreChildWithOnlyTheMother() {
//        Person mother = new Person();
//        Person child = new Person();
//
//        mother.setId(UUID.randomUUID());
//        personRepository.storePerson(mother);
//        child.setMotherId(mother.getId());
//        child.setId(UUID.randomUUID());
//        child.setMotherId(mother.getId());
//        personService.storeChild(child);
//        assertNull(child.getFather());
//        assertNotNull(child.getMother());
//        int countAllPersons = personRepository.getAll().size();
//        assertEquals(2, countAllPersons);
//    }
//
//    @Test
//    public void shouldStoreChildWithOnlyTheFather() {
//        Person father = new Person();
//        Person child = new Person();
//
//        father.setId(UUID.randomUUID());
//        personRepository.storePerson(father);
//        child.setFatherId(father.getId());
//        child.setId(UUID.randomUUID());
//        child.setFather(personRepository.storePerson(child));
//        assertNotNull(child.getFather());
//        assertNull(child.getMother());
//        int countAllPersons = personRepository.getAll().size();
//        assertEquals(2, countAllPersons);
//    }
//
//    @Test
//    public void shouldAddChildToArrayList() {
//        Person father = new Person();
//        Person mother = new Person();
//        Person child = new Person();
//
//        father.setId(UUID.randomUUID());
//        personRepository.storePerson(father);
//        mother.setId(UUID.randomUUID());
//        personRepository.storePerson(mother);
//        child.setId(UUID.randomUUID());
//        child.setFatherId(father.getId());
//        child.setMotherId(mother.getId());
//        personService.storeChild(child);
//        assertEquals(personService.findPersonById(child.getId()), child);
//        int countAllPersons = personRepository.getAll().size();
//        assertEquals(3, countAllPersons);
//    }
//}