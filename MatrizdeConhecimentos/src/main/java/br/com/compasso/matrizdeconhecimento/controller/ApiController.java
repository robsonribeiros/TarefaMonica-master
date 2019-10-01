package br.com.compasso.matrizdeconhecimento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.matrizdeconhecimento.apiservice.ApiService;
import br.com.compasso.matrizdeconhecimento.models.Colaborador;
import br.com.compasso.matrizdeconhecimento.models.MatrizDeConhecimento;
import br.com.compasso.matrizdeconhecimento.models.MatrizDeConhecimentoColaborador;
import br.com.compasso.matrizdeconhecimento.models.DTO.MatrizDeConhecimentoColaboradorDTO;


@RestController 
public class ApiController {

	@Autowired
	private ApiService colaboradorService;


	@GetMapping("/colabs/busca/{cpf}")
	public ResponseEntity<MatrizDeConhecimentoColaborador>BuscaColaboradorCompleto(@PathVariable (value = "cpf")String cpf) {
		
		MatrizDeConhecimentoColaborador colaborador = new MatrizDeConhecimentoColaborador();
		colaborador = colaboradorService.BuscaColaboradorCompleto(cpf);
		return ResponseEntity.status(HttpStatus.OK).body(colaborador);
	}
	
	@GetMapping("/colaborador/busca/{competencia}")
	public ResponseEntity<List<MatrizDeConhecimentoColaborador>> BuscaCompetencia(@PathVariable(value = "competencia") String competencia){
		return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.BuscaCompetencia(competencia));
	}

	@PostMapping("/competencia/{cpf}")
	public ResponseEntity<String>addCompColaboradores(@PathVariable("cpf")String cpf,@RequestBody MatrizDeConhecimento matrizDeConhecimento){
		colaboradorService.addCompColaboradores(matrizDeConhecimento,cpf);
		return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com sucesso");
	}
	
	
	@PutMapping("atualiza/{cpf}")
	public ResponseEntity<?>atualizaUmColaborador(@PathVariable(value = "cpf")String cpf,@RequestBody MatrizDeConhecimentoColaborador colaboradoratualizado){
		colaboradorService.atualizaUmColaborador(cpf, colaboradoratualizado);
		return colaboradorService.atualizaUmColaborador(cpf, colaboradoratualizado);
	}
	
	@PatchMapping(path = "/user/{cpf}")
	public ResponseEntity<String>atualizaDados(@PathVariable(value = "cpf")String cpf,@RequestBody MatrizDeConhecimentoColaboradorDTO m){
		colaboradorService.atualizaDados(cpf, m);
		return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
	}
	
	@DeleteMapping("/delete/{cpf}")
	public ResponseEntity<MatrizDeConhecimentoColaborador>deletaumColaborador(@PathVariable(value= "cpf")String cpf){
		
		return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.deletaumColaborador(cpf));
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<MatrizDeConhecimentoColaborador>>listaColaboradores(){
		return colaboradorService.listaColaboradores();
	}

	
	
	
	
	
	// Buscas na api de colaborador
	
	
	@GetMapping("/colaborador/{cpf}")
	public  ResponseEntity<?> BuscaColaborador(@PathVariable(value = "cpf")String cpf){
		Colaborador colaborador = new Colaborador();
		colaborador = colaboradorService.BuscaColaborador(cpf);
		if(colaborador == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(colaborador);
		}
	}
	
	@GetMapping("/colabs")
	public ResponseEntity<List<Colaborador>> testeApi(){
		return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.Buscatodos());
	}
	
}

