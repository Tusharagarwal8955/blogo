package com.aruiga.blogo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.aruiga.blogo.entities.BlogEntity;

@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int id;
    
    private String author_name;
    
    @Column(unique = true)
    private String emailId;
  
    @OneToMany(mappedBy = "author_id", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<BlogEntity> blogs;

    public AuthorEntity(String author_name, String emailId) {
        System.out.println(emailId);
        this.author_name = author_name;
        this.emailId = emailId;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public AuthorEntity() {}
	
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + author_name + '\'' +
                ", email_id='" + emailId + '\'' +
                '}';
    }
	
}
