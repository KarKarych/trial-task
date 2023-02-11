package com.example.kameleoon.persistence.repository;

import com.example.kameleoon.persistence.entity.Vote;
import com.example.kameleoon.persistence.entity.VoteId;
import com.example.kameleoon.persistence.projection.QuoteChartElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, VoteId> {

  @Query("""
    select  v.date as date,
            sum(case when v.vote = 'UP'   then 1 else 0 end) as upvoteCount,
            sum(case when v.vote = 'DOWN' then 1 else 0 end) as downvoteCount
      from  Vote v
      where v.quoteId = :quoteId
      group by v.date
      order by v.date
    """)
  List<QuoteChartElement> getVotesChart(UUID quoteId);

  Optional<Vote> findByUserIdAndQuoteId(UUID userId, UUID quoteId);

  boolean existsByUserIdAndQuoteId(UUID userId, UUID quoteId);

  void deleteByUserIdAndQuoteId(UUID userId, UUID quoteId);
}
