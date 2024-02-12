package com.gymsystem.gymsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gymsystem.gymsystem.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long>{
	boolean existsByNomContrat(String nomContrat);
	Contrat findByNomContrat(String nomContrat);
	@Query(value = "select * from Contrat u where u.nom like :cle%",nativeQuery = true )
	List<Contrat> getContratSW(@Param ("cle") String ch );
}
