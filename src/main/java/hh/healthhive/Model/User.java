package hh.healthhive.Model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import lombok.ToString;

import javax.persistence.GeneratedValue;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="User",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {


    @Id
    @GeneratedValue
    private int idUser;



    private String user_name;

    private String email;

    private String age;
    private String password;
    private String gender;
    private String first_Name;

    private String last_Name;



}
