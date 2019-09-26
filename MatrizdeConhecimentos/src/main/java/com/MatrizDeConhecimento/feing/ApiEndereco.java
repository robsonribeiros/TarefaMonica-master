package com.MatrizDeConhecimento.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.MatrizDeConhecimento.Models.DTO.Endereco;

@FeignClient(name = "ApiEndereco", url = "http://localhost:8087")
public interface ApiEndereco {

	@GetMapping("/listendereco")
	public List<Endereco>GetEndereco();
	
}
