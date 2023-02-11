package com.example.kameleoon.rest.api;

import com.example.kameleoon.service.model.quote.QuoteChartElementDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ChartApi {

  @GetMapping("/{quoteId}")
  List<QuoteChartElementDto> getCharts(@PathVariable UUID quoteId);
}
