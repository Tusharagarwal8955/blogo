package com.aruiga.blogo.services;

import com.aruiga.blogo.repositories.*;

import java.util.List;
import java.util.Optional;

import com.aruiga.blogo.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BlogService {
    private final BlogRepository blogRepository;

    private final AuthorRepository authorRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository, AuthorRepository authorRepository) {
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }
    
    public List<BlogEntity> getBlogs(){
        List<BlogEntity> blogs = this.blogRepository.sortByDate();
    	System.out.println("polkmo");
        return blogs;
    }

    public String addBlog(BlogEntity blog) {
        try {
            AuthorEntity author = blog.getAuthor_id();
            Optional<AuthorEntity> authorInfo = authorRepository.findById(author.getId());
            if(authorInfo.isPresent()){
                blog.setAuthorId(authorInfo.get());
                this.blogRepository.save(blog);
                return "Blog added";
            } else {
                return "Author not found";
            }
        } catch (Exception e) {
            return "Error adding blog";
        }
    }

    public BlogEntity getBlog(int id) {
        try{
            BlogEntity blog = this.blogRepository.getById(id);
            if(blog != null){
                return blog;
            } else {
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }

}
