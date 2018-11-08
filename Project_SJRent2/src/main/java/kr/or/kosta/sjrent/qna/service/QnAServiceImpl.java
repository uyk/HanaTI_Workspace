package kr.or.kosta.sjrent.qna.service;

import java.util.List;

import kr.or.kosta.sjrent.qna.dao.QnADao;
import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.paging.Params;

public class QnAServiceImpl implements QnAService {

	QnADao qnaDao;
	
	
	public QnADao getQnaDao() {
		return qnaDao;
	}

	public void setQnaDao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
	}

	@Override
	public boolean create(QnA qna) throws Exception {
		return qnaDao.create(qna);


	}

	@Override
	public QnA read(int number) throws Exception {
		return qnaDao.read(number);
	}

	@Override
	public boolean update(QnA qna) throws Exception {
		return qnaDao.update(qna);


	}

	@Override
	public boolean delete(int number) throws Exception {
		return qnaDao.delete(number);


	}

	@Override
	public List<QnA> listAll() throws Exception {
		return qnaDao.listAll();
	}


	
	

	@Override
	public List<QnA> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception {

		return null;
	}

	@Override
	public List<QnA> listByPage(Params params) throws Exception {

		return null;
	}

	@Override
	public int countBySearch(String searchType, String searchValue) throws Exception {

		return 0;
	}

	@Override
	public int countBySearch(Params params) throws Exception {

		return 0;
	}

}
