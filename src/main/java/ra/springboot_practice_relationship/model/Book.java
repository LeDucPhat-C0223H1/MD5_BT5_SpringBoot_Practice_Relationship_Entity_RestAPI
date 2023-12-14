package ra.springboot_practice_relationship.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("id")
    private Category category;

    /* relationship book_author */
    // 1 cuốn sách có nhiều tác giả
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authorList;
}
