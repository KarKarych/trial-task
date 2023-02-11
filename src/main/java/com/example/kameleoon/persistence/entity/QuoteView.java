package com.example.kameleoon.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
  schema = "kameleoon",
  name = "quotes_with_votes"
)
public class QuoteView extends QuoteBase {

  @Column(name = "upvote_count")
  private Integer upvoteCount;

  @Column(name = "downvote_count")
  private Integer downvoteCount;
}
