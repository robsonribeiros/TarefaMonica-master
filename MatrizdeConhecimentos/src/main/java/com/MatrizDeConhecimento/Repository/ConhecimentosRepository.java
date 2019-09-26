package com.MatrizDeConhecimento.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MatrizDeConhecimento.Models.MatrizDeConhecimentoColaborador;

public interface ConhecimentosRepository extends JpaRepository<MatrizDeConhecimentoColaborador,String> {

	List<MatrizDeConhecimentoColaborador>findByCompetencia(String competencia);
	List<MatrizDeConhecimentoColaborador> findByCpf(String cpf);
}
