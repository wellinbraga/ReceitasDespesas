package br.com.wbraga.desafioalura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import br.com.wbraga.desafioalura.entities.Lancamentos;

public interface  LancamentosRepository extends JpaRepositoryImplementation<Lancamentos, Long> {
	
	
	@Query("SELECT l FROM Lancamentos AS l where tipoLancamento = :tipolancamento")
	public List<Lancamentos> findReceitaDespesa(@Param("tipolancamento") Integer tipolancamento);

}
