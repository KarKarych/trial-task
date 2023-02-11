package com.example.kameleoon.rest.controller;

import com.example.kameleoon.rest.api.ChartApi;
import com.example.kameleoon.service.logic.ChartService;
import com.example.kameleoon.service.model.quote.QuoteChartElementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/charts")
@RequiredArgsConstructor
public class ChartController implements ChartApi {

  private final ChartService chartService;

  @Override
  @GetMapping("/{quoteId}")
  public List<QuoteChartElementDto> getCharts(@PathVariable UUID quoteId) {
    return chartService.getCharts(quoteId);
  }
}
