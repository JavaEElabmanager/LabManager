package service;

import java.util.List;

import dao.RecordDao;
import model.Record;


public class RecordService {
	private RecordDao recorddao;

	public RecordDao getRecorddao() {
		return recorddao;
	}

	public void setRecorddao(RecordDao recorddao) {
		this.recorddao = recorddao;
	}
	public void insertrecord(Record record) {
		recorddao.insertRecord(record);
	}
	public Record searchrecord(int recordId) {
		return recorddao.searchRecord(recordId);
	}
	public void updaterecord(Record record) {
		recorddao.updateRecord(record);
	}
	public void deleterecord(Record record) {
		recorddao.deleteRecord(record);
	}
	public List loadallrecord( ) {
		return recorddao.loadallRecord();
	}
}
