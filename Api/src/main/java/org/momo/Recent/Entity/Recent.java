package org.momo.Recent.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Recent")
@NoArgsConstructor
@Getter
@Setter
public class Recent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "recent_id")
  private Long id;

  @Column(name = "title")
  private String title;

  private double price;

  private double rating;

  private int count;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  private String imageUrl;

  @Builder
  public Recent(String title, double price, double rating, int count, LocalDateTime createdAt, String imageUrl) {
    this.title = title;
    this.price = price;
    this.createdAt = createdAt;
    this.imageUrl = imageUrl;
    this.rating = rating;
    this.count = count;
  }
}



