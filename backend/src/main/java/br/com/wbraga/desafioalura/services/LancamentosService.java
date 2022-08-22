package br.com.wbraga.desafioalura.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.com.wbraga.desafioalura.entities.Lancamentos;
import br.com.wbraga.desafioalura.entities.enums.TipoLancamento;
import br.com.wbraga.desafioalura.repositories.LancamentosRepository;

@Service
public class LancamentosService {

	@Autowired
	private LancamentosRepository repository;
	
	public List<Lancamentos> findAll(){
		return repository.findAll();
	}
	
	public List<Lancamentos> findReceitaDespesa(Integer tipoLancamento){
		return repository.findReceitaDespesa(tipoLancamento);
	}
	
	public Lancamentos finById(Long id) {
		Optional<Lancamentos> obj = repository.findById(id);
		return obj.get();
 	}

	public Lancamentos insert(Lancamentos obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Lancamentos update(Long id, Lancamentos obj) {
		Lancamentos entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}
	
	public void updateData(Lancamentos entity, Lancamentos obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setValor(obj.getValor());
		entity.setTipoLancamento(obj.getTipoLancamento());
		entity.setData(obj.getData());
	}
	
}

