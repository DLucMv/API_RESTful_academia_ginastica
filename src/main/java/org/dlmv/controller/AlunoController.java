package org.dlmv.controller;

import jakarta.validation.Valid;
import org.dlmv.entity.Aluno;
import org.dlmv.entity.AvaliacaoFisica;
import org.dlmv.entity.form.AlunoForm;
import org.dlmv.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        //@Valid habilita a validação dos parametros(restricoes) do form
        return service.create(form);

    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                               String dataDeNascimento){
        //required = me retorna independente de passar ou nao o parametro
        return service.getAll(dataDeNascimento);

    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

}
