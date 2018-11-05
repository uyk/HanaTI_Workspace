package kr.or.kosta.sjrent.insurance.service;

import java.util.List;

import kr.or.kosta.sjrent.insurance.dao.InsuranceDao;
import kr.or.kosta.sjrent.insurance.domain.Insurance;

public class InsuranceServiceImpl implements InsuranceService {

	private InsuranceDao insuranceDao;
	
	public InsuranceDao getInsuranceDao() {
		return insuranceDao;
	}

	public void setInsuranceDao(InsuranceDao insuranceDao) {
		this.insuranceDao = insuranceDao;
	}

	@Override
	public Insurance read(int number) throws Exception {
		return insuranceDao.read(number);
	}

	@Override
	public List<Insurance> listAll() throws Exception {
		return insuranceDao.listAll();
	}

}
