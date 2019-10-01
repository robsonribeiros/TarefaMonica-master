package br.com.compasso.matrizdeconhecimento.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.matrizdeconhecimento.models.DTO.Email;
import br.com.compasso.matrizdeconhecimento.models.DTO.Telefone;

@FeignClient(name = "ApiContato", url = "http://localhost:8085")
public interface ApiContato {

	@GetMapping("/listtelefone")
	public List<Telefone>getTelefones();
	
	@GetMapping("/listemail")
	public List<Email>getEmails();
	
	@PostMapping("/telefone/{cpf}")
	Telefone create(@RequestBody Telefone telefone);
	
//	@PutMapping("/up/{cpf}")
//	Telefone telefone = new Telefone();
	
	
	
}
