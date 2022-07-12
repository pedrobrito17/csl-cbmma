package br.gov.ma.ssp.cbm.csl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.ma.ssp.cbm.csl.model.BombeiroMilitar;

@Repository
public interface BombeiroMilitarRepository extends JpaRepository<BombeiroMilitar, Integer>{

	BombeiroMilitar findByMatricula(String matricula);

}