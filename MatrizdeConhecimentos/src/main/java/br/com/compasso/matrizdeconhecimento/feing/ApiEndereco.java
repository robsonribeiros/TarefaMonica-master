package br.com.compasso.matrizdeconhecimento.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.compasso.matrizdeconhecimento.models.DTO.Endereco;

@FeignClient(name = "ApiEndereco", url = "https://enderecocolaborador.herokuapp.com")
public interface ApiEndereco {

	@GetMapping("/swagger-ui.html")
	public List<Endereco>GetEndereco();
	
}
