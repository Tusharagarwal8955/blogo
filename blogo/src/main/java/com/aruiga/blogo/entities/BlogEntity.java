package com.aruiga.blogo.entities;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blog_id")
    private int id;

    private String title;
    
    private String image;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false,referencedColumnName = "author_id")
    private AuthorEntity author_id;
    
    @CreationTimestamp()
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date",nullable = false,updatable=false)
    private Date creationDate;

    public BlogEntity() {
		// TODO Auto-generated constructor stub
	}

    public BlogEntity(String title, String image,String content, AuthorEntity author_id) {
        this.title = title;
        this.image = image;
        this.content = content;
        this.author_id = author_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AuthorEntity getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(AuthorEntity author_id) {
		this.author_id = author_id;
	}

	public void setAuthorId(AuthorEntity author_id) {
        this.author_id = author_id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        if(creationDate != null){
            this.creationDate = creationDate;
        }else{
            this.creationDate = new Date();
        }
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                "Creation Date=" + creationDate + '\'' +
                ", authorId=" + author_id +
                '}';
    }
}
