package kr.or.kosta.sjrent.wishitem.dao;

import java.util.List;

import kr.or.kosta.sjrent.wishitem.domain.WishItem;

public interface WishItemDao {

	public void create (WishItem wishItem) throws Exception;

	public WishItem read (int wishItemNumber) throws Exception;

	public void update (WishItem wishItem) throws Exception;

	public void delete (int wishItemNumber) throws Exception;

	public List<WishItem> listAll() throws Exception;

	public List<WishItem> listByUser(String userId) throws Exception;
}
