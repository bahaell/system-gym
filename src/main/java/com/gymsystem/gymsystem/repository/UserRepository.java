package com.gymsystem.gymsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gymsystem.gymsystem.entities.Role;
import com.gymsystem.gymsystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	boolean existsByNom(String nom);
	User findByNom(String nom);
	@Query(value = "select * from user u where u.nom like :cle%",nativeQuery = true )
	List<User> getUserSW(@Param ("cle") String ch );
	User getUserById(Long iduser);
	boolean existsByRole(Role role);
	List<User> findByRole(Role role);
	
}
