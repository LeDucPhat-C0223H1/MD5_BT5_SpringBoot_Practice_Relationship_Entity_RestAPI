package ra.springboot_practice_relationship.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    /* relationship category_book */
    // nhiều sách có chung 1 category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /* relationship book_author */
    // 1 cuốn sách cso nhiều tác giả
    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authorList;
}
