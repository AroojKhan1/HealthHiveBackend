package hh.healthhive.Repository;

import hh.healthhive.Model.ToDo;
import hh.healthhive.Model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long> {
    @Override
    <S extends ToDo> List<S> findAll(Example<S> example);
}
