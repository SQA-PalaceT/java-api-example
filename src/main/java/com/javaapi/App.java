package com.javaapi;

import java.util.List;

import com.javaapi.api.Api;
import com.javaapi.api.DTOs.CommentDTO;
import com.javaapi.api.DTOs.PostDTO;
import com.javaapi.api.DTOs.Builders.PostDTOBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /** Get Posts Example */
        System.out.println("\nPosts example: \n");
        List<PostDTO> posts = Api.getPosts();
            
        for (PostDTO post : posts){
            System.out.println("### "+ post.title + " ### \n");

            System.out.println("\n" + post.body + "\n");
        }

        System.out.println("Total of posts: " + posts.size());

        /** Get Post Example */
        System.out.println("\nGet Post example: \n");
        PostDTO post = Api.getPost(1);

        System.out.println("### "+ post.title + " ### \n");

        System.out.println("\n" + post.body + "\n");

        /** Create Post Example */
        System.out.println("\nCreate Post example: \n");

        /** Using Constructor */
        PostDTO constructorPostToCreate = new PostDTO(1, "New constructor post title", "New constructor post body");
        PostDTO constructorCreatedPost = Api.createPost(constructorPostToCreate);

        System.out.println("Post created via constructor");

        System.out.println("### "+ constructorCreatedPost.title + " ### \n");

        System.out.println("\n" + constructorCreatedPost.body + "\n");

        /** Using Builder */
        PostDTO builderPostToCreate = new PostDTOBuilder().title("New builder post title").body("New builder post body").buildPostDTO();
        PostDTO builderCreatedPost = Api.createPost(builderPostToCreate);

        System.out.println("Post created via builder");

        System.out.println("### "+ builderCreatedPost.title + " ### \n");

        System.out.println("\n" + builderCreatedPost.body + "\n");

        /** Update Post Example */
        System.out.println("\nUpdate Post example: \n");

        PostDTO postToUpdate = new PostDTO(1, 1, "Updated post title", "Updated post body");
        PostDTO updatetedPost = Api.updatePost(1, postToUpdate);

        System.out.println("Post updated");

        System.out.println("### "+ updatetedPost.title + " ### \n");

        System.out.println("\n" + updatetedPost.body + "\n");

        /** Delete Post Example */
        System.out.println("\nDelete Post example: \n");

        Api.deletePost(1);

        System.out.println("Post deleted");

        /** Nested Comments Example */
        System.out.println("\nNested Comments of post 3 example: \n");

        List<CommentDTO> nestedComments = Api.getPostCommentsNested(3);

        for (CommentDTO comment : nestedComments){
            System.out.println("### "+ comment.name + " ### \n");

            System.out.println("\n" + comment.email + "\n");

            System.out.println("\n" + comment.body + "\n");
        }

        System.out.println("Total of nested comments: " + nestedComments.size());
        
        /** Query Comments Example */
        System.out.println("\nQuery Comments of post 3 example: \n");

        List<CommentDTO> queryComments = Api.getPostCommentsNested(3);

        for (CommentDTO comment : queryComments){
            System.out.println("### "+ comment.name + " ### \n");

            System.out.println("\n" + comment.email + "\n");

            System.out.println("\n" + comment.body + "\n");
        }

        System.out.println("Total of query comments: " + queryComments.size());
    }
}