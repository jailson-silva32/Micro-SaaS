package com.estetica.agendamento.service;

import com.estetica.agendamento.model.Agendamento;
import com.estetica.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.management.RuntimeErrorException;

@Service
public class AgendamentoService {
    
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento salvar(Agendamento agendamento){
        // Verificar se ja existe agendamento para o mesmo profissiona;, data e hora
        Optional<Agendamento> conflito = agendamentoRepository.encontrarConflito(
            agendamento.getProfissional().getId(),
            agendamento.getDataHora()
        );
        

        if (conflito.isPresent()) {
            throw new RuntimeException("Esse horario ja esta reservado para o profissional.");
        }

        return agendamentoRepository.save(agendamento);

    }

    // Metodo listar todos os agendamentos
    public Iterable<Agendamento> listarTodos(){
        return agendamentoRepository.findAll();
    }
    
    //Etapas futuras para atualizar e fazer cancelamentos

    public Agendamento criarAgendamento(Agendamento agendamento) {
        Optional<Agendamento> existente = agendamentoRepository.findByProfissionalAndDataHora(agendamento.getProfissional(), agendamento.getDataHora());

        if (existente.isPresent()){
            throw new RuntimeException("Ja existe um agendamento para este profissional neste horario");
        }

        return agendamentoRepository.save(agendamento);
    }

}


