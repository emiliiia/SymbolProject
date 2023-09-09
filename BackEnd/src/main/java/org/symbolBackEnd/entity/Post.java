package org.symbolBackEnd.entity;
/*
  @author emilia
  @project SymbolProject
  @class Post
  @version 1.0.0
  @since 05.09.2023 - 20:25
*/

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
/*
    @NotNull(message = "AUTHOR may not be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private User author;
*/
    @NotBlank(message = "TITLE may not be null")
    @Size(max = 128, message = "TITLE must be between 1 and 128 characters long")
    private String title;

    @NotBlank(message = "FOREWORD may not be null")
    @Size(max = 150, message = "FOREWORD must be between 1 and 150 characters long")
    private String foreword;

    @NotBlank(message = "CONTENT may not be null")
    private String content;

    @NotNull(message = "PUBLISHED AT may not be null")
    @Column(name="published_at")
    private LocalDateTime publishedAt;

    @Column(name="created_at", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Post() {
    }

    public Post(Integer id, /*User author,*/ String title, String foreword, String content, LocalDateTime publishedAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        //this.author = author;
        this.title = title;
        this.foreword = foreword;
        this.content = content;
        this.publishedAt = publishedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
/*
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
*/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForeword() {
        return foreword;
    }

    public void setForeword(String foreword) {
        this.foreword = foreword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                //", author=" + author +
                ", title='" + title + '\'' +
                ", foreword='" + foreword + '\'' +
                ", content='" + content + '\'' +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
