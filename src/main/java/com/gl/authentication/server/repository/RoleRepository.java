package com.gl.authentication.server.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.gl.authentication.server.model.Role;
import com.gl.authentication.server.model.RoleName;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
  Optional<Role> findByName(RoleName name);

}
