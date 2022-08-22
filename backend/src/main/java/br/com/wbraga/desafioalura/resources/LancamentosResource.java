package br.com.wbraga.desafioalura.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.wbraga.desafioalura.entities.Lancamentos;
import br.com.wbraga.desafioalura.entities.enums.TipoLancamento;
import br.com.wbraga.desafioalura.services.LancamentosService;

@RestController
@RequestMapping(value = "/lancamentos")
public class LancamentosResource {

	@Autowired
	LancamentosService service;

	@GetMapping
	public ResponseEntity<List<Lancamentos>> findAll() {
		List<Lancamentos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Lancamentos> findById(@PathVariable Long id) {
		Lancamentos obj = service.finById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/receitas")
	public ResponseEntity<List<Lancamentos>> findAllReceitas() {
		List<Lancamentos> list = service.findReceitaDespesa(TipoLancamento.RECEITA.getCode());
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/despesas")
	public ResponseEntity<List<Lancamentos>> findAllDespesas() {
		List<Lancamentos> list = service.findReceitaDespesa(TipoLancamento.DESPESA.getCode());
		return ResponseEntity.ok().body(list);
	}

	@PostMapping(value = "/despesas")
	public ResponseEntity<Lancamentos> insertDespesa(@RequestBody Lancamentos obj) {
		obj = service.insert(obj);
		obj.setTipoLancamento(TipoLancamento.DESPESA);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/receitas").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PostMapping(value = "/receitas")
	public ResponseEntity<Lancamentos> insertReceitas(@RequestBody Lancamentos obj) {
		obj.setTipoLancamento(TipoLancamento.RECEITA);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/receitas").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{tipolancamento}/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{tipolancamento}/{id}")
	public ResponseEntity<Lancamentos> update(@PathVariable Long id, @RequestBody Lancamentos obj ){ 
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
