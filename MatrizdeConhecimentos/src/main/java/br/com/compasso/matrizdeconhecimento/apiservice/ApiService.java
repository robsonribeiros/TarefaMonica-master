package br.com.compasso.matrizdeconhecimento.apiservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.compasso.matrizdeconhecimento.exceptions.ColaboradorInexistenteException;
import br.com.compasso.matrizdeconhecimento.exceptions.InvalidCpfException;
import br.com.compasso.matrizdeconhecimento.feing.APIdeColaboradores;
import br.com.compasso.matrizdeconhecimento.models.Colaborador;
import br.com.compasso.matrizdeconhecimento.models.MatrizDeConhecimento;
import br.com.compasso.matrizdeconhecimento.models.MatrizDeConhecimentoColaborador;
import br.com.compasso.matrizdeconhecimento.models.DTO.MatrizDeConhecimentoColaboradorDTO;
import br.com.compasso.matrizdeconhecimento.repository.ConhecimentosRepository;

@Service
public class ApiService {

	@Autowired 
	private APIdeColaboradores apiDeColaboradores;
	@Autowired
	private ConhecimentosRepository conhecimentosRepository;

	/*
	 * Salva um colaborador em meu banco de dados.
	 */
	public void addCompColaboradores(MatrizDeConhecimento matrizDeConhecimento, String cpf) {
		Colaborador colaborador =  new Colaborador();
		colaborador = BuscaColaborador(cpf);
		if(conhecimentosRepository.existsById(cpf)) {
			throw new InvalidCpfException("Cpf já cadastrado para um colaborador!");
		}
		
		MatrizDeConhecimentoColaborador colaboradorCompleto = new MatrizDeConhecimentoColaborador();
		colaboradorCompleto.setCpf(colaborador.getCpf());
		colaboradorCompleto.setNome(colaborador.getNome());
		colaboradorCompleto.setCargo(colaborador.getCargo());
		colaboradorCompleto.setSede(colaborador.getSede());
		colaboradorCompleto.setData_de_nascimento(colaborador.getData_de_nascimento());
		colaboradorCompleto.setData_de_admissao(colaborador.getData_de_admissao());
		colaboradorCompleto.setCompetencia(matrizDeConhecimento.getCompetencia());
		colaboradorCompleto.setExperiencia(matrizDeConhecimento.getExperiencia());
		
		conhecimentosRepository.save(colaboradorCompleto);
	}

	
	/*
	 * Buscar colaborador salvo no meu banco de dados, isto é,
	 * um colaborador que foi consumido da outra api e cadastrado 
	 * os campos competencia e experiencia.
	 */
	public MatrizDeConhecimentoColaborador BuscaColaboradorCompleto(String cpf){
		MatrizDeConhecimentoColaborador buscaColaborador =  null;
	try {
		buscaColaborador = new MatrizDeConhecimentoColaborador();
		buscaColaborador = conhecimentosRepository.findById(cpf).get();

	}catch(Exception e) {
		e.printStackTrace();
		throw new ColaboradorInexistenteException("Colaborador não encontrado!");
	}
		return buscaColaborador;
	}
	

	/*
	 * Método put.
	 */
	public ResponseEntity<String> atualizaUmColaborador(String cpf, MatrizDeConhecimentoColaborador colaboradoratualizado) {
		
		MatrizDeConhecimentoColaborador saved = BuscaColaboradorCompleto(cpf);
		BeanUtils.copyProperties(colaboradoratualizado, saved, "cpf");
		conhecimentosRepository.save(saved);
		return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
	}

	public List<MatrizDeConhecimentoColaborador> BuscaCompetencia(String competencia) {
		
		List<MatrizDeConhecimentoColaborador>buscaCompetencia = new ArrayList<>();
		buscaCompetencia = conhecimentosRepository.findByCompetencia(competencia);
		return buscaCompetencia;
		
	}
	

	/*
	 * atualizaDados para o Patch.
	 */
	
	public void atualizaDados(String cpf, MatrizDeConhecimentoColaboradorDTO m) {
		MatrizDeConhecimentoColaborador colaborador = new MatrizDeConhecimentoColaborador();
		colaborador = BuscaColaboradorCompleto(cpf);
		if(m != null) {
			if( m.getNome()!=null && !m.getNome().isEmpty()) {
				colaborador.setNome(m.getNome());
			}
			if(m.getCargo()!=null && !m.getCargo().isEmpty()) {
				colaborador.setCargo(m.getCargo());
			}
			if( m.getSede()!=null && !m.getSede().isEmpty() ) {
				colaborador.setSede(m.getSede());
			}
			if( m.getData_de_nascimento()!=null && !m.getData_de_nascimento().isEmpty()) {
				colaborador.setData_de_nascimento(m.getData_de_nascimento());
			}
			if( m.getData_de_admissao() != null && !m.getData_de_admissao().isEmpty()) {
				colaborador.setData_de_admissao(m.getData_de_admissao());
			}
			if( m.getCompetencia() != null && !m.getCompetencia().isEmpty()) {
				colaborador.setCompetencia(m.getCompetencia());
			}
			if(m.getExperiencia() != null && !m.getExperiencia().isEmpty()) {
				colaborador.setExperiencia(m.getExperiencia());
			}
		}
		
		conhecimentosRepository.save(colaborador);
	}
	
	
	
	
	public MatrizDeConhecimentoColaborador deletaumColaborador(String cpf) { 
		
		MatrizDeConhecimentoColaborador deletaColaborador = new MatrizDeConhecimentoColaborador();
		deletaColaborador = conhecimentosRepository.findById(cpf).get();
	    conhecimentosRepository.deleteById(cpf);
		return deletaColaborador;
		
	}
	
	
	// Lista todos os cadastrados no meu banco
	
	public ResponseEntity<List<MatrizDeConhecimentoColaborador>> listaColaboradores() { 
		List<MatrizDeConhecimentoColaborador> list = new ArrayList<>();
		list = conhecimentosRepository.findAll();
		List<MatrizDeConhecimentoColaborador> list2 = new ArrayList<>();
			for(MatrizDeConhecimentoColaborador colaborador : list) {
				if (colaborador.getCpf()!=null) {
					list2.add(colaborador);
				}
			}
		return ResponseEntity.status(HttpStatus.OK).body(list2);
	}
	
	
	
	/* Buscas api de colaboradores
	 * Primeiro metodo busca a partir de um cpf 
	 * e "Buscatodos" faz um get de todos os colaboradores
	 * cadastrados na api consumida.
	 */
	
	public Colaborador BuscaColaborador(String cpf) {
		
		List<Colaborador> listColaborador = new ArrayList<>();
		listColaborador = apiDeColaboradores.GetColaboradores();
		Colaborador colaborador = new Colaborador();
		for(Colaborador colaboradores:listColaborador) {
			if(colaboradores.getCpf().equalsIgnoreCase(cpf)) {
				colaborador = colaboradores;  
			}
		}
		
		return colaborador;
	}
	
	public List<Colaborador> Buscatodos() {
		
		return apiDeColaboradores.GetColaboradores();
	}


}