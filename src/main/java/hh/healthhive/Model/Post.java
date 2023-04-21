package hh.healthhive.Model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private  String title;

    @Column(name = "content")
    private  String content;

    @Column(name = "reply_content")
    private  String reply_content;

    @Column(name = "post_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date post_date;

    @Column(name = "time")
    private LocalTime time;

    //    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id", nullable = false)
//    @JsonIgnore
    private Long user;


}
