package com.aruiga.blogo.services;

import com.aruiga.blogo.entities.AuthorEntity;

import com.aruiga.blogo.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorService {
    
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public String addAuthor(AuthorEntity author){
        try{
            this.authorRepository.save(author);
            return author.toString()+"added";
        }catch(Exception e){
            return "Error adding author";
        }
    }
}
