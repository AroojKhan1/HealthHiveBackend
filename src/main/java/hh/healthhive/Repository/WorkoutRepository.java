package hh.healthhive.Repository;

import hh.healthhive.Model.Calorie;
import hh.healthhive.Model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    @Query(value = "select * from workout  where w_date = :wDate", nativeQuery = true)
    List<Workout> findByW_date(String wDate);
}
