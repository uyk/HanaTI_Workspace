package kr.or.kosta.sjrent.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.params.ModelParams;

public interface ModelService {
	
	public void create(Model model) throws Exception;
	
	public Model read(String name) throws Exception;

	public void update(Model model) throws Exception;
	
	public void delete(String name) throws Exception;

	public List<Model> listAll() throws Exception;

	public List<Model> listByPage(int page, int listSize) throws Exception;
	
	public List<Model> listBySearch(int page, int listSize, String startDate, String endDate, String fuelType, int seater,
			String transmission, String navigation, String cameraRear, String blackBox) throws Exception;
	
	public List<Model> listBySearch(ModelParams modelParams) throws Exception;

	public int countBySearch(int page, int listSize, String startDate, String endDate, String fuelType, int seater,
			String transmission, String navigation, String cameraRear, String blackBox) throws Exception;
	
	public int countBySearch(ModelParams modelParams) throws Exception;
	
	public List<Model> PopularModel(int num) throws Exception;
	
	public List<Model> recommendModel(int num) throws Exception;
	
	public boolean changeCount(String name, int num) throws Exception;
	
	public List<String> checkEnableCar(String startDate, String endDate, String modelName) throws Exception;
	
	public Model recommend(String result) throws Exception;
	
	public Map<String, HashMap<String, ArrayList<String>>> periodByModelName(String modelName) throws Exception;
}
