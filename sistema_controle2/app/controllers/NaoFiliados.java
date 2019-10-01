package controllers;

import java.util.List;

import models.Filiado;
import models.NaoFiliado;
import play.mvc.Controller;

public class NaoFiliados extends Controller {

	public static void form() {
		render();
	}
	
	public static void editar(Long id) {
		NaoFiliado naoFiliado = NaoFiliado.findById(id);
		render("NaoFiliados/form.html", naoFiliado);		
	}
	
	public static void salvar(NaoFiliado naoFiliado) {
		naoFiliado.save();
		flash.success("Cadastro realizado com sucesso!");
		form();
	}
	public static void certo() {
	}
	
	public static void deletar(Long id) {
		NaoFiliado naoFiliado = NaoFiliado.findById(id);
		naoFiliado.delete();
		listar();
	}
	
	public static void buscar (String parteNome) {
		List<NaoFiliado> naoFiliados = NaoFiliado.find("nome like ?", "%" + parteNome + "%").fetch();
		render("NaoFiliados/listar.html", naoFiliados);
		
	}
	
	public static void listar() {
		List<NaoFiliado> naoFiliados = NaoFiliado.findAll();
		render(naoFiliados);
	}
}