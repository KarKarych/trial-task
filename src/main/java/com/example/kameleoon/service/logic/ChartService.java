package com.example.kameleoon.service.logic;

import com.example.kameleoon.service.model.quote.QuoteChartElementDto;
import com.example.kameleoon.service.validation.constraint.QuoteIdExists;
import com.example.kameleoon.service.validation.group.NotFoundGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

import java.util.List;
import java.util.UUID;

public interface ChartService {

  List<QuoteChartElementDto> getCharts(
    @NotNull
    @QuoteIdExists(groups = {Default.class, NotFoundGroup.class})
    UUID quoteId
  );
}
