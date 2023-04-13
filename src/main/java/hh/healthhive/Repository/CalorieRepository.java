package hh.healthhive.Repository;

import hh.healthhive.Model.Calorie;
import hh.healthhive.Model.SymptomJournal;
import hh.healthhive.Model.ToDo;
import hh.healthhive.Model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface CalorieRepository extends JpaRepository<Calorie,Long> {
    @Query(value = "select * from calorie  where meal_date = :mealDate", nativeQuery = true)
    List<Calorie> findByMeal_date(String mealDate);

    @Query(value = "select * from calorie  where user_id = :userId", nativeQuery = true)
    List<Calorie> findByUserId(Long userId);

    @Query(value = "select * from calorie  where meal_date = :mealDdate and user_id = :userId", nativeQuery = true)
    List<Calorie> findByMeal_date_AndUserId(String mealDdate, Long userId);

}
