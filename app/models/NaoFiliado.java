package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class NaoFiliado extends Model {
	
	public String nome;
	public Long cpf;
	public String cidade;
}