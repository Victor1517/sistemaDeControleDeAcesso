package jobs;

import models.Campi;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if(Usuario.count() == 0) {
			Usuario usuario = new Usuario();
			usuario.password = "admin";
			usuario.user = "admin";
			usuario.save();
			
			
		}
		if(Campi.count() == 0) {
			Campi campi1 = new Campi();
			campi1.nome = "Macau";
			campi1.save();
			
			Campi campi2 = new Campi();
			campi2.nome = "Parelhas";
			campi2.save();
			
			Campi campi3 = new Campi();
			campi3.nome = "Natal";
			campi3.save();
		}
		
	}
	
}