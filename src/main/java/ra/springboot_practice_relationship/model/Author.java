package ra.springboot_practice_relationship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String name;

    /* relationship zipcode_author */
    // Nhiều author chung 1 zipcode (nhiều tác giả sống cùng 1 thành phố)
    @ManyToOne
    @JoinColumn(name = "zipcode_id")
    @JsonIgnore
    private ZipCode zipCode;

    /* relationship book_author */
    // 1 tác giả viết ra nhiều cuốn sách
    @ManyToMany (mappedBy = "authorList")
    @JsonIgnore
    private List<Book> bookList;
}
