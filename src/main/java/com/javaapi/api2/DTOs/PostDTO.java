package com.javaapi.api.DTOs;

/**
 * Post Data Transfer Object
 */
public class PostDTO {
    public int id;
    public int userId;
    public String title;
    public String body;
    

    public PostDTO(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public PostDTO(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}