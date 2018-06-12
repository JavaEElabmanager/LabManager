package service;
import java.util.List;

import dao.ComputerDao;
import model.Computer;


public class ComputerService {
	private ComputerDao computerdao;
	
	public ComputerDao getComputerdao() {
		return computerdao;
	}
	public void setComputerdao(ComputerDao computerdao) {
		this.computerdao = computerdao;
	}
	public void insertcomputer(Computer computer) {
		computerdao.insertComputer(computer);
	}
	public Computer searchcomputer(int computerId) {
		return computerdao.searchComputer(computerId);
	}
	public void updatecomputer(Computer computer) {
		computerdao.updateComputer(computer);
	}
	public void deletecomputer(Computer computer) {
		computerdao.deleteComputer(computer);
	}
	public List loadallcomputer( ) {
		return computerdao.loadallComputer();
	}
}
