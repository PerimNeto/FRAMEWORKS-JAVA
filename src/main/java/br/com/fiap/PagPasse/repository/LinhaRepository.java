package br.com.fiap.PagPasse.repository;

import br.com.fiap.PagPasse.model.Linha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LinhaRepository extends JpaRepository<Linha, Long> {

    public Optional<Linha> findById(Long id);
    public List<Linha> findByNomeLinha(String nomeLinha);
    public List<Linha> findByRota(String rota);

    // Métodos para buscar por intervalo de fechas
    public List<Linha> findByTempoEstimadoBetween(Date startDate, Date endDate);
    public List<Linha> findByDataUltimaAtualizacaoBetween(Date startDate, Date endDate);

    // Métodos para buscar por intervalos de horarios
    public List<Linha> findByHorarioInicioBetween(Date startDate, Date endDate);
    public List<Linha> findByHorarioFimBetween(Date startDate, Date endDate);
}
