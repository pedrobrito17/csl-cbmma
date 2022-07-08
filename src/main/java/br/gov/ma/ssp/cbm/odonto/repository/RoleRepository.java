package br.gov.ma.ssp.cbm.odonto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.ma.ssp.cbm.odonto.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	List<Role> findByRole(String role);

}