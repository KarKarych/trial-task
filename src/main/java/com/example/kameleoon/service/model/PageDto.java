package com.example.kameleoon.service.model;

import java.util.List;

public record PageDto<T>(
  List<T> items,
  Integer pageNumber,
  Integer pageSize,
  Integer totalPages
) {
}
