package model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "user")//mapped-по какому признаку группируем
    private Identificator identificator;

    @ManyToOne(fetch = FetchType.LAZY)//когда достаем юзера,не сразу группы будут подгружаться,ленивая инициализация=не сразу,еще есть агрессивная
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)//когда достаем юзера,не сразу группы будут подгружаться,ленивая инициализация=не сразу,еще есть агрессивная
    @JoinColumn(name = "report_id")
    private Report report;


    public User() {//конструктор не нужен,если добавить аннотацию????

    }
}