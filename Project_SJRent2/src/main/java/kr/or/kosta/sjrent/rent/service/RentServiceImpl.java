package kr.or.kosta.sjrent.rent.service;

import java.util.List;

import kr.or.kosta.sjrent.rent.dao.RentDao;
import kr.or.kosta.sjrent.rent.domain.Rent;

public class RentServiceImpl implements RentService {

	RentDao rentDao;
	
	public RentDao getRentDao() {
		return rentDao;
	}

	public void setRentDao(RentDao rentDao) {
		this.rentDao = rentDao;
	}

	@Override
	public boolean create(Rent rent) throws Exception {
		return rentDao.create(rent);
	}

	@Override
	public Rent read(int number) throws Exception {
		return rentDao.read(number);
	}

	@Override
	public void update(Rent review) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int number) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Rent> listAll(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rent> listByUser(String userId) throws Exception {
		return rentDao.listByUserId(userId);
	}

	@Override
	public boolean cancel(int number) throws Exception {
		return rentDao.cancel(number);
	}

	@Override
	public List<Rent> CancellistByUser(String userId) throws Exception {
		return rentDao.listByUserId(userId, 1);
	}

	@Override
	public List<Rent> UncancellistByUser(String userId) throws Exception {
		return rentDao.listByUserId(userId, 0);
	}

	@Override
	public List<Rent> pastListByUser(String userId) throws Exception {
		return rentDao.pastListByUserId(userId);
	}

}
