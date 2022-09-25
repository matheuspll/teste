package com.estacio.evento.model;

import com.estacio.evento.model.enums.AlunoStatus;
import com.estacio.evento.model.enums.TipoParticipante;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno implements Participante, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = true, length = 15)
    private String telefone;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 15)
    private Integer matricula;

    private Integer alunoStatus;

    private Integer tipoParticipante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @JsonIgnore
    @ManyToMany(mappedBy = "alunos")
    private Set<Atividade> atividades = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public AlunoStatus getAlunoStatus() {
        return AlunoStatus.valueOf(alunoStatus);
    }

    public void setAlunoStatus(AlunoStatus alunoStatus) {
        if (alunoStatus != null) {
            this.alunoStatus = alunoStatus.getCode();
        }
    }

    @Override
    public TipoParticipante getTipoParticipante() {
        return TipoParticipante.valueOf(tipoParticipante);
    }

    @Override
    public void setTipoParticipante(TipoParticipante tipoParticipante) {
        if (tipoParticipante != null) {
            this.tipoParticipante = tipoParticipante.getCode();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno that = (Aluno) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
