package controllers;

import java.util.List;

import models.Usuario;
import play.mvc.Controller;

public class Usuarios extends Controller {

	public static void form() {
		render();
	}

	public static void logado() {
		render();
	}

	public static void editar(Long id) {
		Usuario usuario = Usuario.findById(id);
		render(usuario);
	}

	public static void salvar(Usuario usuario) {
		usuario.save();
		flash.success("Cadastro realizado com sucesso!");
		login();
		
		
		
		
	}

	public static void login() {
		render();
	}

	public static void deletar(Long id) {
		Usuario usuario = Usuario.findById(id);
		usuario.delete();
		listar();
	}

	public static void listar() {
		List<Usuario> usuarios = Usuario.findAll();
		render(usuarios);
	}

	public static void autenticador(Usuario usuario) {
		List<Usuario> usuarios = Usuario.find("user = ? and password = ?", usuario.user, usuario.password).fetch();
		if (usuarios.isEmpty())
			flash.error("Usuario ou senha invalidos");
			
		else
			render("Usuarios/logado.html");
		login();
	} 
}
