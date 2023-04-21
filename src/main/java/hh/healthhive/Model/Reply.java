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
@Table(name="Reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "post_id")
    private long post_id;


    @Column (name="content")
    private String content;



    @Column(name = "reply_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date reply_date;

    @Column(name = "time")
    private LocalTime time;

//    @ManyToOne
//    Post post;
}
