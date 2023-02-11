package com.example.kameleoon.service.logic.impl;

import com.example.kameleoon.persistence.repository.VoteRepository;
import com.example.kameleoon.service.logic.ChartService;
import com.example.kameleoon.service.mapper.QuoteChartElementMapper;
import com.example.kameleoon.service.model.quote.QuoteChartElementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class ChartServiceImpl implements ChartService {

  private final VoteRepository voteRepository;

  private final QuoteChartElementMapper quoteChartElementMapper;

  @Override
  public List<QuoteChartElementDto> getCharts(UUID quoteId) {
    return voteRepository.getVotesChart(quoteId)
      .stream()
      .map(quoteChartElementMapper::toQuoteChartElementDto)
      .toList();
  }
}
