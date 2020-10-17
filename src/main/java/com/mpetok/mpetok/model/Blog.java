package com.mpetok.mpetok.model;

public class Blog {

  private String title;

  private String description;

  Blog(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public String getTitle() {
    return title;
  }

}
