package com.aruiga.blogo.controllers;

import com.aruiga.blogo.entities.*;

import com.aruiga.blogo.services.*;

//import com.books.bootbooks.services.BlogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ResponseEntity<List<BlogEntity>> getBlogs() {
        try{
            List<BlogEntity> blogs = this.blogService.getBlogs();
            return ResponseEntity.ok().body(blogs);
        }catch(Exception e){
            System.out.println("Internal Server Error, getting List.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BlogEntity> getBlog(@PathVariable int id) {
        try{
            BlogEntity blog = this.blogService.getBlog(id);
            return ResponseEntity.ok().body(blog);
        }catch(Exception e){
            System.out.println("Internal Server Error, getting Blog.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @PostMapping("/add/blog")
    public ResponseEntity<String> addBlog(@RequestBody BlogEntity blog) {
        try{
            String message = this.blogService.addBlog(blog);
            System.out.println(message);
            return ResponseEntity.status(HttpStatus.CREATED).body("Blog Added.");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error, Error adding blog");
        }
    }
}