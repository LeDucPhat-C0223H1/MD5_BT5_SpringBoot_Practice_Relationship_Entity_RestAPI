package ra.springboot_practice_relationship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String name;

    /* relationship city_zipcode */
    // 1 city chỉ có 1 zipcodde
    @OneToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties({"id","zipCode"})
    private City city;

    /* relationship zipcode_author */
    // 1 zipcode có nhiều author (nhiều tác giả sống cùng 1 thành phố)
    @OneToMany (mappedBy = "zipCode")
    @JsonIgnore
    private List<Author> authorList;
}
