package com.mpetok.mpetok.controller;

import java.util.ArrayList;
import java.util.List;

import com.mpetok.mpetok.domain.Story;
import com.mpetok.mpetok.repository.StoryRepository;
import com.mpetok.mpetok.service.StoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private StoryService storyService;

    @Autowired 
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping("/")
    public String home(){
        //amikor atadod html-re 
        //tudsz hivatkozni, mint story.blogger.name
        //szoval objektum->objektum->tulajdonsag 
        storyService.getStories().forEach(System.out::println);
        return "home";
    }

    @RequestMapping("/story")
    public String story(){
        System.out.println(
            "Megvan : " + 
            storyService.getStory("Teszt cim").toString()
        );
        return "home";
    }

    @RequestMapping("/title/{title}")
    public String title(@PathVariable(value  = "title") String title) throws Exception {
        if(title == null){
            throw new Exception("Nincs ilyen cimmel story");
        }
        System.out.println(storyService.getSpecificStory(title));

        return "home";
    }
}