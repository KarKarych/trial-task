package com.example.kameleoon.service.mapper;

import com.example.kameleoon.persistence.entity.QuoteView;
import com.example.kameleoon.service.model.quote.QuoteDto;
import org.mapstruct.Mapper;

@Mapper(uses = {
  UserMapper.class
})
public abstract class QuoteMapper {

  public abstract QuoteDto toQuoteDto(QuoteView quoteView);
}
