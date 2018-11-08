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
	public void create(WishItem wishItem) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public WishItem read(int wishItemNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(WishItem wishItem) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int wishItemNumber) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<WishItem> listByUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
