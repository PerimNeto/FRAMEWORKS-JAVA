package br.com.fiap.PagPasse.repository;


import br.com.fiap.PagPasse.model.Linha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LinhaRepository extends JpaRepository<Linha, Long> {

    public Optional<Linha> findById(Long id);

    public List<Linha> findByNomeLinha(String nomeLinha);

    public List<Linha> findByRota(String rota);

    public List<Linha> findByTempoEstimadoBetween(LocalDate tempoEstimado);

    public Optional<Linha> findByLocalizacaoAtual(String localizacaoAtual);

    public Optional<Linha> findByDataUltimaLocalizacaoBetween(LocalDate dataUltimaLocalizacao);

    public List<Linha> findByHorarioInicioBetween(LocalDate horarioInicio);

    public List<Linha> findByHorarioFimBetween(LocalDate horarioFim);

}

