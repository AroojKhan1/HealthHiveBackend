package hh.healthhive.Repository;

import hh.healthhive.Model.ToDo;
import hh.healthhive.Model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<ToDo, Long> {

    <S extends ToDo> List<S> findAll(Example<S> example);


//    @Query(value = "select * from to_do  where id = :itemId", nativeQuery = true)
//    List<ToDo> findById(Long itemId);
    @Query(value = "select * from to_do  where user_id = :userId", nativeQuery = true)
    List<ToDo> findByUserId(Long userId);

}
