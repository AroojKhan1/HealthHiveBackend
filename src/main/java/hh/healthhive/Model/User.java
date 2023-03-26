package hh.healthhive.Model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="User",uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class User {


    @Id
    @GeneratedValue
    private int idUser;

    @NotNull
    private String user_name;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private String age;

    @Column(nullable = false)
    @Size(min = 8, max = 20)
    @NotNull
    private String password;


    private String gender;

    @NotNull
    private String role;


    private String first_Name;

    private String last_Name;


    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();



}
