package kr.or.kosta.sjrent.wishitem.service;

import java.util.List;

import kr.or.kosta.sjrent.wishitem.dao.WishItemDao;
import kr.or.kosta.sjrent.wishitem.domain.WishItem;

public class WishItemServiceImpl implements WishItemService {

	private WishItemDao wishItemDao;
	
	public WishItemDao getWishItemDao() {
		return wishItemDao;
	}

	public void setWishItemDao(WishItemDao wishItemDao) {
		this.wishItemDao = wishItemDao;
	}

	@Override
	public boolean create(WishItem wishItem) throws Exception {
		return wishItemDao.create(wishItem);
	}

	@Override
	public WishItem read(int wishItemNumber) throws Exception {
		return wishItemDao.read(wishItemNumber);
	}

	@Override
	public boolean delete(int wishItemNumber) throws Exception {
		return wishItemDao.delete(wishItemNumber);
	}

	@Override
	public List<WishItem> listByUser(String userId) throws Exception {
		return wishItemDao.listByUser(userId);
	}

}
