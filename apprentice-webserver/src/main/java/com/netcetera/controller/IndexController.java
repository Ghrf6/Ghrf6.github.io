package com.netcetera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Entrypoint for the index page.
 * <p>
 * '@RequestMapping' is set to be "/" which is the root path when accessing localhost:8080.
 */
@Controller
@RequestMapping("/")
public class IndexController {

  @GetMapping
  public String getIndexPage(Model model) {
    model.addAttribute("indexAttribute", "This text is from the IndexController");
    return "index";
  }
}
