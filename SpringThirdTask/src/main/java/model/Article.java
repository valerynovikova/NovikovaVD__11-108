package model;

import lombok.*;
import lombok.AllArgsConstructor;
import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Setter
@Data
@Builder
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 16)
    private String name;

    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "articles_topics",
            joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id")
    )
    private List<Topic> topics;


    public Article() {

    }
}

