package com.example.kameleoon.persistence.entity;

import com.example.kameleoon.service.model.VoteEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VoteId.class)
@Entity
@Table(
  schema = "kameleoon",
  name = "votes"
)
public class Vote extends BaseEntity {

  @Id
  @Column(name = "quote_id")
  private UUID quoteId;

  @Id
  @Column(name = "user_id")
  private UUID userId;

  @Enumerated(EnumType.STRING)
  private VoteEnum vote;

  @LastModifiedDate
  private LocalDate date;
}
