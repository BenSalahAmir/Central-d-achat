package tn.esprit.forumms.Mappers;


import tn.esprit.forumms.DTOentities.PostDto;
import tn.esprit.forumms.Entity.Post;

public class PostMapper {
    public static PostDto mapToDto(Post post){
        PostDto postDto = PostDto.builder()
                .categoryPost(post.getCategoryPost())
                .descriptionPost(post.getDescriptionPost())
                .dateCreationPost(post.getDateCreationPost())
                .imagePost(post.getImagePost())
                .topicPost(post.getTopicPost())
                .userPost(post.getUserPost())
                .build();
        return postDto;
    }
    public static Post mapToEntity(PostDto postDto){
        Post post = Post.builder()
                .categoryPost(postDto.getCategoryPost())
                .descriptionPost(postDto.getDescriptionPost())
                .dateCreationPost(postDto.getDateCreationPost())
                .imagePost(postDto.getImagePost())
                .topicPost(postDto.getTopicPost())
                .userPost(postDto.getUserPost())
                .build();
        return post;
    }
}
