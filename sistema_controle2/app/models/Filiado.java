package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Filiado extends Model {

	public String nome;
	public Long matricula;
	
	@ManyToOne
	@JoinColumn(name="idcampi")
	public Campi campi;
}