package com.agencia.reservas.repository;

import com.agencia.reservas.model.entity.AgentesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AgentesRepository extends JpaRepository<AgentesEntity, String> {

}