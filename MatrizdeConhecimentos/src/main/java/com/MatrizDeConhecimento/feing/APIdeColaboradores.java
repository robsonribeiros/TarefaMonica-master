package com.MatrizDeConhecimento.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.MatrizDeConhecimento.Models.Colaborador;

@FeignClient (name ="APIdeColaboradores", url = "https://atlantic-caterpillar.glitch.me")

public interface APIdeColaboradores {

	@GetMapping("/colaboradores")
	public List<Colaborador>GetColaboradores();

}
