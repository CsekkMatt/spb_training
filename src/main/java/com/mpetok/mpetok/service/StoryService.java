package com.mpetok.mpetok.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import com.mpetok.mpetok.domain.Blogger;
import com.mpetok.mpetok.domain.Story;
import com.mpetok.mpetok.repository.BloggerRepository;
import com.mpetok.mpetok.repository.StoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Service annotation && Controller annoation
//Megmondja, hogy SINGLETON lesz.
@Service
public class StoryService {

    private StoryRepository storyRepository;
    private BloggerRepository bloggerRepository;
    
    @Autowired
    public void setStoryRepository(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Autowired
    public void setBloggerRepository(BloggerRepository bloggerRepository) {
        this.bloggerRepository = bloggerRepository;
    }

	public Iterable<Story> getStories() {
		return storyRepository.findAll();
    }

    public Story getStory(String title){
        return storyRepository.findByTitle(title);
    }
    
    @PostConstruct
    public void init(){
        Blogger blogger = new Blogger("BelsoMate",23);
        bloggerRepository.save(blogger);
        Story story = new Story("BelsoCim","BelsoTartalom",new Date(),blogger);
        storyRepository.save(story);

    }

	public Story getSpecificStory(String title) { 
        return storyRepository.findByTitle(title);
	}
    
}
