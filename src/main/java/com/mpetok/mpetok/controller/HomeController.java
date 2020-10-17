package com.mpetok.mpetok.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mpetok.mpetok.service.StoryService;

@Controller
public class HomeController {

  private StoryService storyService;

  @Autowired
  public void setStoryService(StoryService storyService) {
    this.storyService = storyService;
  }

  @RequestMapping("/")
  public String home() {
    // amikor atadod html-re
    // tudsz hivatkozni, mint story.blogger.name
    // szoval objektum->objektum->tulajdonsag
    storyService.getStories().forEach(System.out::println);
    return "home";
  }

  @RequestMapping("/stories")
  public String stories(Model model, Locale locale) {
    model.addAttribute("pageTitle", "Az oldal Cime ITT VAN!");
    model.addAttribute("stories", this.storyService.getStories());
    System.out.println(locale.getDisplayCountry().toString());
    return "stories";
  }

  @ExceptionHandler(Exception.class)
  public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
    model.addAttribute("errMessage", ex.getMessage());
    return "exceptionHandler";
  }

  @RequestMapping("/story")
  public String story() {
    System.out.println("Megvan : " + storyService.getStory("Teszt cim").toString());
    return "home";
  }

  @RequestMapping("/title/{title}")
  public String title(@PathVariable(value = "title") String title) throws Exception {
    if (title == null) {
      throw new Exception("Nincs ilyen cimmel story");
    }
    System.out.println(storyService.getSpecificStory(title));

    return "home";
  }
}