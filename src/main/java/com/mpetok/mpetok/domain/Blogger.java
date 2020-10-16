package com.mpetok.mpetok.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Blogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)   
    private Long id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "blogger")
    private List<Story> stories;

    private Blogger(){
        //
    }

    public Blogger(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setStories(List<Story> stories) {
        this.stories = stories;
    }
    public List<Story> getStories() {
        return stories;
    }
    
}
