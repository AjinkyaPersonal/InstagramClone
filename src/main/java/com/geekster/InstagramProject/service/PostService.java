package com.geekster.InstagramProject.service;

import com.geekster.InstagramProject.dto.PostOutput;
import com.geekster.InstagramProject.model.Post;
import com.geekster.InstagramProject.model.User;
import com.geekster.InstagramProject.repo.IPostRepo;
import com.geekster.InstagramProject.repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    @Autowired
    LikeService likeService;

    @Autowired
    ITokenRepo tokenRepo;
    public void addPost(Post post) {
        postRepo.save(post);
    }

    public List<PostOutput> getAllPosts(String token) {
        User user = tokenRepo.findFirstByToken(token).getUser();


        List<Post> postList = postRepo.findByUser(user);
        List<PostOutput> postOutputList = new ArrayList<>();

        for(Post post : postList){
            PostOutput postOutput = new PostOutput();
            postOutput.setInstagramName(user.getInstagramName());
            postOutput.setPostData(post.getPostData());
            postOutput.setPostCaption(post.getPostCaption());
            postOutput.setCreatedDate(post.getCreatedDate());
            postOutput.setLocation(post.getLocation());
            postOutputList.add(postOutput);
        }

        return postOutputList;


    }

    public long getLikes(Long postId) {

         return likeService.getLikes(postId);
    }

}
