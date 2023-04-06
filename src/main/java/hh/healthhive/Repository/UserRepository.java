package hh.healthhive.Repository;



        import hh.healthhive.Model.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;


        import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);

    @Query(value = "select * from User where user_name = :user_name", nativeQuery = true  )
    User findByUsername(String user_name);
}