package org.dlmv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data //Lombok (getters, seters, ...)
@NoArgsConstructor
@AllArgsConstructor
@Entity //Relativo a persistenci no DB
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL) //Alterações feitas em avaliacaoFisica se reflete em aluno
    @JoinColumn(name = "aluno_id") //Contem a coluna de ForeingKey
    private Aluno aluno;

    private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

    @Column(name = "peso_atual")
    private double peso;

    @Column(name = "altura_atual")
    private double altura;
}
