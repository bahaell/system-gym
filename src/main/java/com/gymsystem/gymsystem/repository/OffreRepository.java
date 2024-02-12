package com.gymsystem.gymsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gymsystem.gymsystem.entities.Offre;

public interface OffreRepository extends JpaRepository<Offre, Long>{
	boolean existsByNomOffre(String nomOffre);
	Offre findByNomOffre(String nomOffre);
	@Query(value = "select * from Offre u where u.nom like :cle%",nativeQuery = true )
	List<Offre> getOffreSW(@Param ("cle") String ch );
}
