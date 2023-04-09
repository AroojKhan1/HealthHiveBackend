package hh.healthhive.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Water_Intake")
public class WaterIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    //user is to record number of glasses of
    //water they had at the end of
    //each day. try and see if u can
    // allow this feild to be updated
    @Column(name = "num_glasses")
    private  int num_glasses;

    @Column(name = "water_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date water_date;


    @Column(name = "water_time")
    private LocalTime water_time;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id_user")
    @JsonIgnore
    private User user;


}
