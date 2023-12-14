package ra.springboot_practice_relationship.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String name;

    /* relationship city_zipcode */
    // 1 city chỉ có 1 zipcodde
    @JsonIgnore // bỏ qua trường này khi trả về kết quả Json
    @OneToOne (mappedBy = "city")
    private ZipCode zipCode;
}
