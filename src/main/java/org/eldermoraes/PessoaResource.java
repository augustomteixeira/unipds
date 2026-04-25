package org.eldermoraes;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {
	
	@GET
	public List<Pessoa> getPessoa() {
		return Pessoa.listAll();
	}
	
	@GET
	@Path("findByAnoNascimento")
	public List<Pessoa> findByAnoNascimento(@QueryParam("anoNascimento") int anoNascimento) {
		return Pessoa.findByAnoNascimento(anoNascimento);
	}
	
	@POST
	@Transactional
	public Pessoa addPessoa(Pessoa pessoa) {
		pessoa.id = null; // Garantir que o ID seja gerado automaticamente pelo banco de dados.
		pessoa.persist();
		
		return pessoa;
	}
	
	@PUT
	@Transactional
	public Pessoa updatePessoa(Pessoa pessoa) {
		Pessoa p = pessoa.findById(pessoa.id);
		p.nome = pessoa.nome;
		p.anoNascimento = pessoa.anoNascimento;
		p.persist();
		
		return p;
	}
	
	@DELETE
	@Transactional
	public void deletePessoa(int id) {
		Pessoa.deleteById(id);
	}

}
