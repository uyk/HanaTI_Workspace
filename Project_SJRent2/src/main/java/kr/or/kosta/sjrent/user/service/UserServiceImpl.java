package kr.or.kosta.sjrent.user.service;

import java.util.List;

import org.apache.log4j.Logger;

import kr.or.kosta.sjrent.user.dao.UserDao;
import kr.or.kosta.sjrent.user.domain.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean create(User user) throws Exception{
			return userDao.create(user);
	}

	@Override
	public User read(String id) throws Exception {
		return userDao.read(id);
	}

	@Override
	public User readByCellphone(String cellphone) throws Exception {
		return userDao.readByCellphone(cellphone);
	}

	@Override
	public User readByEmail(String email) throws Exception {
		return userDao.readByEmail(email);
	}
	
	@Override
	public boolean update(User user) throws Exception {
		return userDao.update(user);
	}

	@Override
	public boolean delete(String id) throws Exception {
		return userDao.delete(id);
	}

	@Override
	public User certify(String id, String password) throws Exception {
		User user = userDao.certify(id, password);
		return user;
	}

	@Override
	public boolean isExistId(String id) throws Exception {
		return userDao.isExistId(id);
	}

	@Override
	public boolean isExistEmail(String email) throws Exception {
		return userDao.isExistEmail(email);
	}

	@Override
	public int addPoint(String id, int point) throws Exception {
		boolean addResult = userDao.addPoint(id, point);
		if(addResult) {
			return checkPoint(id);
		}else {
			return -9999;
		}
	}

	@Override
	public int checkPoint(String id) throws Exception {
		return userDao.checkPoint(id);
	}

}





