package com.mpetok.mpetok.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)   
    private Long id;
    private String title;
    @Column(length = 1000)
    private String content;
    private Date posted;
    @ManyToOne
    private Blogger blogger;


    private Story(){
        //private constructor for JPA
    }

    public Story(String title,String content, Date posted,Blogger blogger){
        this.title = title;
        this.content = content;
        this.posted = posted;
        this.blogger = blogger;
    }

    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }
    public Blogger getBlogger() {
        return blogger;
    }

    public String getContent() {
        return content;
    }
    public Date getPosted() {
        return posted;
    }
    public String getTitle() {
        return title;
    }
  
    public void setContent(String content) {
        this.content = content;
    }
    public void setPosted(Date posted) {
        this.posted = posted;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //ID-t ne adj meg .. setter/getter/
    // akkor automata generalas sem fog menni rendesen

    // public void setId(Long id) {
    //     this.id = id;
    // }
    // public long getId() {
    //     return id;
    // }

    @Override
    public String toString() {
        
        return "Tite: " + title + " content: " + content + " author: " + blogger.getName();
    }
    
    
}
