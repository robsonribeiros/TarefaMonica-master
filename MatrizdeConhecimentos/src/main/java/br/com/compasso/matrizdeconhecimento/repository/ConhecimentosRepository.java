package br.com.compasso.matrizdeconhecimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.matrizdeconhecimento.models.MatrizDeConhecimentoColaborador;

public interface ConhecimentosRepository extends JpaRepository<MatrizDeConhecimentoColaborador,String> {

	List<MatrizDeConhecimentoColaborador>findByCompetencia(String competencia);
	List<MatrizDeConhecimentoColaborador> findByCpf(String cpf);
}
