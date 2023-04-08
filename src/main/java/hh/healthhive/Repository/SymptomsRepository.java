package hh.healthhive.Repository;

import hh.healthhive.Model.SymptomJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomsRepository extends JpaRepository<SymptomJournal,Long> {
}
