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
	public List<QnA> listByPage(int page, int listSize) throws Exception {
		return qnaDao.listByPage(page, listSize);
	}

	@Override
	public int count() throws Exception {
		return qnaDao.countAll();
	}

	@Override
	public boolean writeAnswer(int seq, String answer) throws Exception {
		QnA qna = new QnA();
		qna.setNumber(seq);
		qna.setAnswer(answer);
		return qnaDao.update(qna);
	}


}
