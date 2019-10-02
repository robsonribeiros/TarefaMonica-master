package br.com.compasso.matrizdeconhecimento.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.compasso.matrizdeconhecimento.models.DTO.Email;
import br.com.compasso.matrizdeconhecimento.models.DTO.Telefone;

@FeignClient(name = "ApiContato", url = "https://contatocolaborador.herokuapp.com/swagger-ui.html")
public interface ApiContato {

	@GetMapping("/listTelefoneUsingGET")
	public List<Telefone>geTelefones();
	
	@GetMapping("/listemail{cpf}")
	public List<Email>getEmails();

}
