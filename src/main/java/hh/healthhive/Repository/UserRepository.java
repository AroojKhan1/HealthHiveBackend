package hh.healthhive.Repository;



        import hh.healthhive.Model.User;
        import org.springframework.data.jpa.repository.JpaRepository;


        import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);
}