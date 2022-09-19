package com.estacio.evento.repository;

import com.estacio.evento.model.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
}
