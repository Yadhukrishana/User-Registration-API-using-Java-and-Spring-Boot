package com.YADHU.CRUD_APP.Repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.YADHU.CRUD_APP.Model.Users;
@Repository

public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String email);
	void deleteByEmail(String email ) ;
	
}
