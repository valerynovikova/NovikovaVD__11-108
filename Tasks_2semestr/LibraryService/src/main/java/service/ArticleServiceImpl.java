package service;

import dto.ArticleResponseDto;
import repository.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleResponseDto> findAll() {
        return articleRepository.findAll().stream().map(u -> ArticleResponseDto.builder()
                .name(u.getName())
                .id(u.getId())
                .build()
        ).collect(Collectors.toList());
    }
}


