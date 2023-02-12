package com.example.kameleoon.service.logic;

import com.example.kameleoon.service.model.quote.QuoteChartElementDto;
import com.example.kameleoon.service.validation.constraint.QuoteIdExists;
import com.example.kameleoon.service.validation.group.NotFoundGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated({Default.class, NotFoundGroup.class})
public interface ChartService {

  List<QuoteChartElementDto> getCharts(
    @NotNull
    @QuoteIdExists(groups = NotFoundGroup.class)
    UUID quoteId
  );
}
