package hh.healthhive.Repository;

import hh.healthhive.Model.SymptomJournal;
import hh.healthhive.Model.WaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterRepository extends JpaRepository<WaterIntake,Long> {

    @Query(value = "select * from water_intake  where user_id = :userId", nativeQuery = true)
    List<WaterIntake> findByUserId(Long userId);

}
