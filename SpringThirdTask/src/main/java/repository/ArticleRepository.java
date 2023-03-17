package repository;

import model.Article;
import model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Article getArticleByName(String name);

    List<Article> findAllById(List<Integer> ids);

    Page<Article> findAll(Pageable pageable);


    @Query(value = "select a from Article a where a.id in :ids")
    List<Article> findAllByIds(@Param("ids") List<Integer> ids);

    @Query(value = "select a from Article a where a.name = :name and a.id = :id")
    User findArticleByNameAndId(@Param("name") String name, @Param("id") Integer id);

}
