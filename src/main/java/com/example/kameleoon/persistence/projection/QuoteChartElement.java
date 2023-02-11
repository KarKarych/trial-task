package com.example.kameleoon.persistence.projection;

import java.time.LocalDate;

public interface QuoteChartElement {

  LocalDate getDate();

  Integer getUpvoteCount();

  Integer getDownvoteCount();
}
