package com.estetica.agendamento.controller;

import com.estetica.agendamento.model.Agendamento;
import com.estetica.agendamento.model.Cliente;
import com.estetica.agendamento.model.Servico;
import com.estetica.agendamento.repository.AgendamentoRepository;
import com.estetica.agendamento.repository.ClienteRepository;
import com.estetica.agendamento.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    //POST /agendamentos - criar agendamento
    @PostMapping
    public Agendamento criAgendamento(@RequestBody AgendamentoRequest request) {
        Cliente cliente = clienteRepository.findById(request.clienteId()).orElseThrow();
        Servico servico = servicoRepository.findById(request.servicoId()).orElseThrow();

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setServico(servico);
        agendamento.setDataHora(request.dataHora());

        return agendamentoRepository.save(agendamento);
    }

    // GET /agendamentos - Listar todos os agendamentos
    @GetMapping
    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    //Classe auxiliar para receber os dados da requicao
    public record AgendamentoRequest(Long clienteId, Long servicoId, LocalDateTime dataHora) {
    }
}