package dto;

import lombok.Builder;
import lombok.Data;
import model.Article;
@Data
@Builder
public class ArticleResponseDto {
    private Integer id;

    private String name;


    public static ArticleResponseDto fromEntity(Article article) {
        return ArticleResponseDto.builder()
                .id(article.getId())
                .name(article.getName())
                .build();
    }
}
