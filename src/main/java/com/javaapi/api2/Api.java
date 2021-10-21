package com.javaapi.api;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.javaapi.api.DTOs.CommentDTO;
import com.javaapi.api.DTOs.PostDTO;

public class Api {
    
    public static List<PostDTO> getPosts(){
        
        List<PostDTO> posts = Arrays.asList(new Gson().fromJson(Calls.get("posts"), PostDTO[].class));
        return posts;
    }

    public static PostDTO getPost(int postId){

        PostDTO post = new Gson().fromJson(Calls.get("posts/" + postId), PostDTO.class);
        return post;
    }

    public static PostDTO createPost(PostDTO postToCreate){

        PostDTO createdPost = new Gson().fromJson(Calls.post("posts", new Gson().toJson(postToCreate)), PostDTO.class);
        return createdPost;
    }

    public static PostDTO updatePost(int postId, PostDTO postToUpdate){
        
        PostDTO updatedPost = new Gson().fromJson(Calls.put("posts/" + postId, new Gson().toJson(postToUpdate)), PostDTO.class);
        return updatedPost;
    }

    public static PostDTO deletePost(int postId){
        
        PostDTO deletedPost = new Gson().fromJson(Calls.delete("posts/" + postId), PostDTO.class);
        return deletedPost;
    }

    public static List<CommentDTO> getPostCommentsNested(int postId){

        List<CommentDTO> comments = Arrays.asList(new Gson().fromJson(Calls.get("posts/" + postId + "/comments"), CommentDTO[].class));
        return comments;
    }

    public static List<CommentDTO> getPostCommentsQuery(int postId){

        List<CommentDTO> comments = Arrays.asList(new Gson().fromJson(Calls.get("comments?postId=" + postId), CommentDTO[].class));
        return comments;
    }
}