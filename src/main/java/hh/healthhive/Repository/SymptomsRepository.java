package hh.healthhive.Repository;

import hh.healthhive.Model.SymptomJournal;
import hh.healthhive.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomsRepository extends JpaRepository<SymptomJournal,Long> {
    @Query(value = "select * from symptom_journal  where user_id = :userId", nativeQuery = true)
    List<SymptomJournal> findByUserId(Long userId);

}
