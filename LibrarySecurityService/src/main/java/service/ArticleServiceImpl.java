package service;
//авторизация-дает какие то права
//аутентификация-проверяет еслть ли доступ или нет
/* pring security- оддерживает авторизацию
* timeliv-почти как фримаркер,ток разметка html,а не собственная,для него тоже есть starter,позволяет использовать web.jar
* контроль доступа к страничкам
* где то надо хранить права для пользователя который залогинился-контекст нужен,user details  */
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


