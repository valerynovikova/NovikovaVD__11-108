package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String name;

    @ManyToMany(mappedBy = "topics")
    List<Article> articles;

    @ManyToMany(mappedBy = "topics")
    List<Report> reports;
}
