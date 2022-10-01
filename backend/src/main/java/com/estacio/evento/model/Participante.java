package com.estacio.evento.model;

import com.estacio.evento.model.enums.ParticipanteStatus;
import com.estacio.evento.model.enums.TipoParticipante;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_PARTICIPANTE")
@NoArgsConstructor
public class Participante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;

    @Column(nullable = true, length = 15)
    private String telefone;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 15)
    private Integer matricula;

    private Integer participanteStatus;

    private Integer tipoParticipante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public ParticipanteStatus getParticipanteStatus() {
        return ParticipanteStatus.valueOf(participanteStatus);
    }

    public void setParticipanteStatus(ParticipanteStatus participanteStatus) {
        if (participanteStatus != null) {
            this.participanteStatus = participanteStatus.getCode();
        }
    }

    public TipoParticipante getTipoParticipante() {
        return TipoParticipante.valueOf(tipoParticipante);
    }

    public void setTipoParticipante(TipoParticipante tipoParticipante) {
        if (tipoParticipante != null) {
            this.tipoParticipante = tipoParticipante.getCode();
        }
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
