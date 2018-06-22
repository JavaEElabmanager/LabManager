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
		return computerdao.searchComputerById(computerId);
	}
	public Computer searchComputerByPosition(int computerPosition) {
		return computerdao.searchComputerByPosition(computerPosition);
	}
	public Computer searchComputerByPosition(int labId, int computerPosition) {
		return computerdao.searchComputerByPosition(labId, computerPosition);
	}
	public Computer searchComputerByIp(String ip) {
		return computerdao.searchComputerByIp(ip);
	}
	public List searchComputerByLabId(int LabId) {
		return computerdao.searchComputerByLabId(LabId);
	}
	public List searchComputerByLabIdAndPosition(int LabId, int computerPosition) {
		return computerdao.searchComputerByLabIdAndPosition(LabId, computerPosition);
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
