package hh.healthhive.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Calorie")
public class Calorie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "meal_typ")
    private  String meal_typ;

    @Column(name = "calorie")
    private  int calorie;

    @Column(name = "meal_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date meal_date;

    //    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id", nullable = false)
//    @JsonIgnore
    private Long user;

}
