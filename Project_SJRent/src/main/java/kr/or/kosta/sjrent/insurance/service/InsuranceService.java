package kr.or.kosta.sjrent.insurance.service;

import java.util.List;

import kr.or.kosta.sjrent.insurance.domain.Insurance;

public interface InsuranceService {
	
	public Insurance read(int number) throws Exception;

	public List<Insurance> listAll() throws Exception;
}
