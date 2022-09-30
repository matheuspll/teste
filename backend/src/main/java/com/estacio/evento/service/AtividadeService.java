package com.estacio.evento.service;

import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.model.Atividade;
import com.estacio.evento.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private CategoriaService categoriaService;

    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public Optional<Atividade> findById(Long id) {
        return atividadeRepository.findById(id);
    }

    @Transactional
    public Atividade save(Atividade atividade) {
        Atividade atividadeParaSerInserida = Atividade.builder()
                .titulo(atividade.getTitulo())
                .descricao(atividade.getDescricao())
                .categoria(categoriaService.findById(atividade.getCategoria().getId()).orElseThrow(
                        () -> {
                            throw new RegraNegocioException("Essa categoria não existe");
                        }
                ))
                .build();
        return atividadeRepository.save(atividadeParaSerInserida);
    }

    @Transactional
    public void delete(Atividade atividade) {
        atividadeRepository.delete(atividade);
    }
}
