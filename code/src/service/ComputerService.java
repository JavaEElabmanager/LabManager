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
	public Computer searchComputerById(int computerId) {
		return computerdao.searchComputerByPosition(computerId);
	}
	public Computer searchComputerByPosition(int computerPosition) {
		return computerdao.searchComputerByPosition(computerPosition);
	}
	public Computer searchComputerByPositionAndLabId(int computerPosition, int labId, String ip) {
		return computerdao.searchComputerByPositionAndLabId(computerPosition, labId, ip);
	}
	public List searchComputerByLabId(int LabId) {
		return computerdao.searchComputerByLabId(LabId);
	}
	public List searchComputerByLabIdNotusing(int LabId) {
		return computerdao.searchComputerByLabIdNotusing(LabId);
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
