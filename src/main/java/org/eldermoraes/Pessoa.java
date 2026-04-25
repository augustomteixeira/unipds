package org.eldermoraes;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Pessoa extends PanacheEntity {
	
	// Se deixar os atributos como public, o Panache já os mapeia automaticamente, sem necessidade de getters e setters.
	public String nome;
	public int anoNascimento;
	
	public static List<Pessoa> findByAnoNascimento(int ano) {
		return find("anoNascimento", ano).list();
	}

}
