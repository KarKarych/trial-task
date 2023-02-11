package com.example.kameleoon.service.mapper;

import com.example.kameleoon.persistence.projection.QuoteChartElement;
import com.example.kameleoon.service.model.quote.QuoteChartElementDto;
import org.mapstruct.Mapper;

@Mapper
public abstract class QuoteChartElementMapper {

  public abstract QuoteChartElementDto toQuoteChartElementDto(QuoteChartElement quoteChartElement);
}
