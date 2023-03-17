package controller;


import dto.ArticleResponseDto;
import dto.CreateArticleRequestDto;
import lombok.AllArgsConstructor;
import model.Article;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.ArticleRepository;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;

    @PostMapping("/article")
    public ArticleResponseDto createArticle(@Valid @RequestBody CreateArticleRequestDto article) {
        return ArticleResponseDto.fromEntity(articleRepository.save(
                Article.builder()
                        .name(article.getName().trim())
                        .build()
        ));
    }


}