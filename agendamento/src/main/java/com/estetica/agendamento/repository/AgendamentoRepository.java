package com.estetica.agendamento.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estetica.agendamento.model.Agendamento;
import com.estetica.agendamento.model.Profissional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Optional<Agendamento> findByProfissionalAndDataHora(Profissional profissional, LocalDateTime dataHora);

    @Query("SELECT a FROM Agendamento a WHERE a.profissional.id = :profissionalId AND a.dataHora = :dataHora")
Optional<Agendamento> encontrarConflito(@Param("profissionalId") Long profissionalId, @Param("dataHora") LocalDateTime dataHora);

}

