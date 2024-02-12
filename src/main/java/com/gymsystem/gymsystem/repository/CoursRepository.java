package com.gymsystem.gymsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gymsystem.gymsystem.entities.Cours;
import com.gymsystem.gymsystem.entities.Spécialité;

public interface CoursRepository extends JpaRepository<Cours, Long>{
	boolean existsByNomC(Spécialité nomC);
	Cours findByNomC(Spécialité nomC);
	@Query(value = "select * from Cours u where u.nom like :cle%",nativeQuery = true )
	List<Cours> getCoursSW(@Param ("cle") String ch );
}
