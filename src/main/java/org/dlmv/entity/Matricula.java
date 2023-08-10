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
@Table(name = "tb_matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL) //Exclusão da matrícula implica na exclusão do aluno
    @JoinColumn(name = "aluno_id") //Contem a Coluna de ForeingKey
    private Aluno aluno;

    private LocalDateTime dataDaMatricula = LocalDateTime.now();

}
