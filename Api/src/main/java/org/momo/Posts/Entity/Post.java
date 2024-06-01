package org.momo.Posts.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.momo.Member.Entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Post")
@NoArgsConstructor
@Getter
@Setter
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private User member;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  private String imageUrl;

  private String url;


  @Enumerated(EnumType.STRING)
  private Category category;

  @Builder
  public Post(User member, String title, String content, LocalDateTime createdAt, LocalDate lostDate, String imageUrl, Category category) {
    this.member = member;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.imageUrl = imageUrl;
    this.category = category;
  }
}



