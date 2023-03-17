package service;

import dto.ArticleResponseDto;

import java.util.List;

public interface ArticleService {

    List<ArticleResponseDto> findAll();
}
