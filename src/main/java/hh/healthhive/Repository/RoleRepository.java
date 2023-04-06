package hh.healthhive.Repository;

import hh.healthhive.Model.Role;
import hh.healthhive.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}

