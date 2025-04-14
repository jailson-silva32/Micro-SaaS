package com.estetica.agendamento.controller;

import com.estetica.agendamento.model.Servico;
import com.estetica.agendamento.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    // Post /servicos - Cadastrar servicos
    @PostMapping
    public Servico criaServico(@RequestBody Servico servico) {
        return servicoRepository.save(servico);
    }

    //GET /servico - Listar todos os servicos
    @GetMapping
    public List<Servico> listaServicos() {
        return servicoRepository.findAll();
    }
}