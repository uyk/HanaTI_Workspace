package kr.or.kosta.sjrent.model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<String, ArrayList<String>> periodByModelName(String modelName) throws Exception {
		Map<String, ArrayList<String>> last = new HashMap<String, ArrayList<String>>();
		List<Map<String, Object>> ModelList = modelDao.periodByModelName(modelName);
		for(Map<String, Object> map : ModelList) {
			if(!last.containsKey(map.get("CAR_NUM"))) {
				last.put((String)map.get("CAR_NUM"), new ArrayList<String>());
			}
			String startDate = (String)map.get("RENT_START_DATE");
			String endDate = (String)map.get("RENT_END_DATE");
			String[] resultDays = getDiffDays(startDate, endDate);
			for(int i = 0; i < resultDays.length; i++) {
				String year = resultDays[i].substring(0, 4);
				String month = resultDays[i].substring(4, 6);
				String days = resultDays[i].substring(6, 8);
				last.get((String)map.get("CAR_NUM")).add(year+"."+month+"."+days);
			}
		}
		return last;
	}
	
	public static String[] getDiffDays(String fromDate, String toDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();

		try {
		cal.setTime(sdf.parse(fromDate));
		} catch (Exception e) {
		}

		int count = getDiffDayCount(fromDate, toDate);

		// 시작일부터
		cal.add(Calendar.DATE, -1);

		// 데이터 저장
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i <= count; i++) {
		cal.add(Calendar.DATE, 1);

		list.add(sdf.format(cal.getTime()));
		}

		String[] result = new String[list.size()];

		list.toArray(result);

		return result;
		}
		/**
		* 두날짜 사이의 일수를 리턴
		* 
		* @param fromDate
		* yyyyMMdd 형식의 시작일
		* @param toDate
		* yyyyMMdd 형식의 종료일
		* @return 두날짜 사이의 일수
		*/
		public static int getDiffDayCount(String fromDate, String toDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
		try {
		return (int) ((sdf.parse(toDate).getTime() - sdf.parse(fromDate)
		.getTime()) / 1000 / 60 / 60 / 24);
		} catch (Exception e) {
		return 0;
		}
		}

		@Override
		public int countWishItemByModelName(String modelName) throws Exception {
			return modelDao.countWishItemByModelName(modelName);
		}
}
