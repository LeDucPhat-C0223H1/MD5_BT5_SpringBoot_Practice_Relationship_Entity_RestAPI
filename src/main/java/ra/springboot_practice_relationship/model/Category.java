package ra.springboot_practice_relationship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String name;

    /* relationship category_book */
    // 1 category sẽ có nhiều sách
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> bookList;
}
