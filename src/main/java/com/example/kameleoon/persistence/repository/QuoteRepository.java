package com.example.kameleoon.persistence.repository;

import com.example.kameleoon.persistence.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuoteRepository extends JpaRepository<Quote, UUID> {
}
