package com.netcetera.controller;

import com.netcetera.model.Person;
import com.netcetera.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Entrypoint for person related operations from the HTML.
 * <p>
 * Supports all GET, POST, PUT, DELETE operations. Currently, GET and POST are used.
 */
@Controller
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

  private final PersonService personService;

  @GetMapping
  public String getPersonPage(Model model) {
    model.addAttribute("personList", personService.getPersonList());
    model.addAttribute("person", new Person());
    return "person/person";
  }

    @GetMapping("/parent")
    public String getParentPage(Model model){
        model.addAttribute("person", new Person());
        return "parent/parent";
    }

    @PostMapping
    public String addPerson(@ModelAttribute Person person, Model model) {
        Person storedPerson = personService.storeChild(person);
        model.addAttribute("person", storedPerson);
        return "person/personSubmission";
    }

    @PostMapping("/parent")
    public String addParent(@ModelAttribute Person person, Model model) {
        Person storedPerson = personService.storeParent(person);;
        model.addAttribute("parent", storedPerson);
        return "person/personSubmission";
    }

  @GetMapping("/list")
  public String getPersonList(Model model) {
    model.addAttribute("personList", personService.getPersonList());
    return "person/personList";
  }

  // TODO: Add new endpoint to fetch a specific user by an ID
  // Use path parameter mapping, new service/repository method
  // Minimum: Database implementation.
}
