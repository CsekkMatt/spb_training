package com.mpetok.mpetok.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpetok.mpetok.domain.Story;
import com.mpetok.mpetok.service.StoryService;

@RestController
public class ApiController {

  private StoryService storyService;

  @Autowired
  public void setStoryService(StoryService storyService) {
    this.storyService = storyService;
  }

  @RequestMapping("/blogs")
  public Iterable<Story> stories(Model model, Locale locale) {
    return this.storyService.getStories();
  }

  @RequestMapping("/blogger/{name}")
  public Iterable<Story> getBlogger(@PathVariable(value = "name") String name) {
    return this.storyService.getStoriesByBloggerName(name);

  }

  @RequestMapping("/blog/{title}")
  public Story title(@PathVariable(value = "title") String title) throws Exception {
    if (title == null) {
      throw new Exception("Nincs ilyen cimmel story");
    }
    System.out.println(storyService.getSpecificStory(title));
    return storyService.getSpecificStory(title);
  }
}
