//package hh.healthhive.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.sql.Time;
//
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Table(name="Symptom_Journal")
//public class SymptomJournal {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Column(name = "symptoms")
//    private  String symptoms;
//
//
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @Column(name = "symptom_date")
//    private Date symptom_date;
//
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "time")
//    private Time time;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId", referencedColumnName = "id_user", nullable = false)
//    @JsonIgnore
//    private User user;
//}
