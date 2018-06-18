package service;

import java.util.List;

import dao.LabDao;
import model.Lab;


public class LabService {
	private LabDao labdao;

	public LabDao getLabdao() {
		return labdao;
	}

	public void setLabdao(LabDao labdao) {
		this.labdao = labdao;
	}
	public void insertlab(Lab lab) {
		labdao.insertLab(lab);
	}
	public Lab searchlab(String labname) {
		return labdao.searchLab(labname);
	}
	public List searchLabByName(String Labname) {
		return labdao.searchLabByName(Labname);
	}
	public void updatelab(Lab lab) {
		labdao.updateLab(lab);
	}
	public void deletelab(Lab lab) {
		labdao.deleteLab(lab);
	}
	public List loadalllab( ) {
		return labdao.loadallLab();
	}
}
