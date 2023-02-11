package com.example.kameleoon.persistence.repository;

import com.example.kameleoon.persistence.entity.QuoteView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuoteViewRepository extends JpaRepository<QuoteView, UUID> {

  @Query("""
     from   QuoteView qv
     order by rand()
     limit 1
    """)
  Optional<QuoteView> findRandomQuoteWithVotes();

  @Query(value = """
    from   QuoteView qv
    order by qv.upvoteCount + qv.downvoteCount desc,
             qv.creationDate desc
    limit 10
    """)
  List<QuoteView> findTop10Quotes();

  @Query(value = """
    from   QuoteView qv
    order by qv.upvoteCount + qv.downvoteCount,
             qv.creationDate desc
    limit 10
    """)
  List<QuoteView> findFlop10Quotes();

  @Query(value = """
    from   QuoteView qv
    order by qv.creationDate desc
    """)
  Page<QuoteView> getLastQuotes(Pageable pageable);

  @Query(value = """
    from   QuoteView qv
    where qv.user.id = :userId
    order by qv.creationDate desc
    """)
  Page<QuoteView> getLastQuotesByUser(UUID userId, Pageable pageable);
}
