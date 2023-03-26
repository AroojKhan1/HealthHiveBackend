package hh.healthhive.Repository;

import hh.healthhive.Model.Role;
import hh.healthhive.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}

