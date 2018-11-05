package kr.or.kosta.sjrent.faq.service;

import java.util.List;

import kr.or.kosta.sjrent.faq.dao.FAQDao;
import kr.or.kosta.sjrent.faq.domain.FAQ;

public class FAQServiceImpl implements FAQService {

	private FAQDao faqDao;
	
	
	public FAQDao getFaqDao() {
		return faqDao;
	}

	public void setFaqDao(FAQDao faqDao) {
		this.faqDao = faqDao;
	}

	@Override
	public FAQ read(int number) throws Exception {
		return faqDao.read(number);
	}

	@Override
	public List<FAQ> listAll() throws Exception {
		return faqDao.listAll();
	}

}
