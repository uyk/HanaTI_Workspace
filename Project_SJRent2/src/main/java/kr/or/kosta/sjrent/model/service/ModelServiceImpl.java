package kr.or.kosta.sjrent.model.service;

import java.util.List;

import kr.or.kosta.sjrent.model.dao.ModelDao;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.params.ModelParams;
import kr.or.kosta.sjrent.review.dao.ReviewDao;

public class ModelServiceImpl implements ModelService {

	ModelDao modelDao;
	
	public ModelDao getModelDao() {
		return modelDao;
	}

	public void setModelDao(ModelDao modelDao) {
		this.modelDao = modelDao;
	}

	@Override
	public void create(Model model) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Model read(String name) throws Exception {
		return modelDao.read(name);
	}

	@Override
	public void update(Model model) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String name) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Model> listAll() throws Exception {
		return modelDao.listAll();
	}

	@Override
	public List<Model> listByPage(int page, int listSize) throws Exception {
		return listAll();
	}

	@Override
	public List<Model> listBySearch(int page, int listSize, String startDate, String endDate, String fuelType,
			int seater, String transmission, String navigation, String cameraRear, String blackBox) throws Exception {
		return listAll();
	}

	@Override
	public List<Model> listBySearch(ModelParams modelParams) throws Exception {
		return modelDao.listBySearch(modelParams);
	}

	@Override
	public int countBySearch(int page, int listSize, String startDate, String endDate, String fuelType, int seater,
			String transmission, String navigation, String cameraRear, String blackBox) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countBySearch(ModelParams modelParams) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Model> PopularModel(int num) throws Exception {
		return modelDao.popularModel(num);
	}

	@Override
	public List<Model> recommendModel(int num) throws Exception {
		return PopularModel(num);
	}

}
