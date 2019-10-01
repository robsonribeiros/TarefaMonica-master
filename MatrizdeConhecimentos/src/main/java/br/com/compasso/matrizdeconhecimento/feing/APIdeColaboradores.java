package br.com.compasso.matrizdeconhecimento.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.compasso.matrizdeconhecimento.models.Colaborador;

@FeignClient (name ="APIdeColaboradores", url = "https://atlantic-caterpillar.glitch.me")

public interface APIdeColaboradores {

	@GetMapping("/colaboradores")
	public List<Colaborador>GetColaboradores();

}
