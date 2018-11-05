package kr.or.kosta.sjrent.faq.service;

import java.util.List;

import kr.or.kosta.sjrent.faq.domain.FAQ;

public interface FAQService {
	
	public FAQ read(int number) throws Exception;

	public List<FAQ> listAll() throws Exception;
}
