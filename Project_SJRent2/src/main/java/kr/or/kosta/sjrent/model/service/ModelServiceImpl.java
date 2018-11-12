package kr.or.kosta.sjrent.model.service;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import kr.or.kosta.sjrent.common.listener.ServletContextLoadListener;
import kr.or.kosta.sjrent.model.dao.ModelDao;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.params.ModelParams;

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

	@Override
	public boolean changeCount(String name, int num) throws Exception {
		return modelDao.changeCount(name, num);
	}

	@Override
	public List<String> checkEnableCar(String startDate, String endDate, String modelName) throws Exception {
		return modelDao.checkEnableCar(startDate, endDate, modelName);
	}

	@Override
	public Model recommend(String result) throws Exception {
		String[] choosed = result.split(",");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder parser = factory.newDocumentBuilder();
		String WEBINFpath = ServletContextLoadListener.class.getResource("").getPath();
		WEBINFpath = WEBINFpath.substring(0,WEBINFpath.indexOf("/WEB-INF"))+"/WEB-INF/";
		Document xmlDoc = parser.parse(WEBINFpath+"recommend.xml");
		Element rootElement = xmlDoc.getDocumentElement();
		NodeList genderNL = rootElement.getElementsByTagName("gender");
		String modelName = "";
		for(int i = 0; i < genderNL.getLength(); i++) {
			Element element = (Element)genderNL.item(i);
			if(element.getAttribute("value").equals(choosed[0])) {
				NodeList celebNL = element.getElementsByTagName("celeb");
				for(int j = 0; j < celebNL.getLength(); j++) {
					element = (Element)celebNL.item(j);
					if(element.getAttribute("value").equals(choosed[1])) {
						NodeList travelNL = element.getElementsByTagName("travel");
						for(int k = 0; k < travelNL.getLength(); k++) {
							element = (Element)travelNL.item(k);
							if(element.getAttribute("value").equals(choosed[2])) {
								NodeList hobbyNL = element.getElementsByTagName("hobby");
								for(int l = 0; l < hobbyNL.getLength(); l++) {
									element = (Element)hobbyNL.item(l);
									if(element.getAttribute("value").equals(choosed[3])) {
										modelName = element.getTextContent();
									}
								}
							}
						}
					}
				}
			}
		}
		return modelDao.read(modelName);
	}

}
