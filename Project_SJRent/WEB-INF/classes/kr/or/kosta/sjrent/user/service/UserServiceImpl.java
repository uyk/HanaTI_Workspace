package kr.or.kosta.sjrent.user.service;

import java.util.List;
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
	public User search(String id) throws Exception {
		return userDao.read(id);
	}

	@Override
	public List<User> list() throws Exception {
		return userDao.listAll();
	}

}





