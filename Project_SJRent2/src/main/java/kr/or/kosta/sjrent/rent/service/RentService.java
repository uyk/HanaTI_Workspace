package kr.or.kosta.sjrent.rent.service;

import java.util.List;

import kr.or.kosta.sjrent.rent.domain.Rent;

public interface RentService {
	public boolean create(Rent rent) throws Exception;
	
	public Rent read(int number) throws Exception;

	public void update(Rent rent) throws Exception;
	
	public void delete(int number) throws Exception;

	public List<Rent> listAll(int page, int listSize) throws Exception;

	public List<Rent> listByUser(String userId) throws Exception;

	public List<Rent> CancellistByUser(String userId) throws Exception;

	public List<Rent> UncancellistByUser(String userId) throws Exception;

	public List<Rent> pastListByUser(String userId) throws Exception;

	public List<Rent> upComingListByUser(String userId) throws Exception;
	
	public boolean cancel(int number) throws Exception;
	
	public String modelNameByCarNum(String carNumber) throws Exception;
}
