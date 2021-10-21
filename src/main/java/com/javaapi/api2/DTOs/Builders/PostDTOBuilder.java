package com.javaapi.api.DTOs.Builders;

import com.javaapi.api.DTOs.PostDTO;

/**
 * Post Data Transfer Object Builder
 */
public class PostDTOBuilder {
    private int _userId = 1;
    private String _title;
    private String _body;

    public PostDTOBuilder(){}
    
    public PostDTO buildPostDTO(){
        return new PostDTO(_userId, _title, _body);
    }

    public PostDTOBuilder userId(int userId){
        this._userId = userId;
        return this;
    }

    public PostDTOBuilder title(String title){
        this._title = title;
        return this;
    }

    public PostDTOBuilder body(String body){
        this._body = body;
        return this;
    }
}
