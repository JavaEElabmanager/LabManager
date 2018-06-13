package service;

import java.util.List;

import dao.AdministratorDao;
import model.Administrator;



public class AdministratorService {
	private AdministratorDao administratordao;
	public AdministratorDao getAdministratordao() {
		return administratordao;
	}
	public void setAdministratordao(AdministratorDao administratordao) {
		this.administratordao = administratordao;
	}
	public void insertadministrator(Administrator admin) {
		 administratordao.insertAdministrator(admin);
	}
	public Administrator searchadministrator(String adminname) {
		return administratordao.searchAdministrator(adminname);
	}
	public void updateadministrator(Administrator admin) {
		administratordao.updateAdministrator(admin);
	}
	public void deleteadministrator(Administrator admin) {
		administratordao.deleteadminitrator(admin);
	}
	public List loadalladministrator( ) {
		return administratordao.loadallAdministrator();
	}
}
