package controllers;

import java.util.List;

import models.Campi;
import models.Filiado;
import play.mvc.Controller;

public class Filiados extends Controller {

	public static void form() {
		List<Campi> campis = Campi.findAll();
		render(campis);
		
	}
	
	public static void editar(Long id) {
		Filiado filiado = Filiado.findById(id);
		List<Campi> campis = Campi.findAll();
		
		render("Filiados/form.html", filiado, campis);		
	}
	
	public static void salvar(Filiado filiado) {
		filiado.save();
		
		flash.success("Cadastro realizado com sucesso!");
		form();
		
	}
	
	public static void certo() {
	}
	
	public static void deletar(Long id) {
		Filiado filiado = Filiado.findById(id);
		filiado.delete();
		listar();
	}
	
	public static void buscar (String parteNome) {
		List<Filiado> filiados = Filiado.find("nome like ?", "%" + parteNome + "%").fetch();
		render("Filiados/listar.html", filiados);
		
	}
	
	public static void listar() {
		List<Filiado> filiados = Filiado.findAll();
		render(filiados);
		
	}
}
