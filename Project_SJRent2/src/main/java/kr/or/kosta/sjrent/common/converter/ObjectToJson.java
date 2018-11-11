package kr.or.kosta.sjrent.common.converter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.simple.JSONObject;

public class ObjectToJson {

	public ObjectToJson() {
		super();
	}
	public JSONObject ObjectToJsonObject(Object object) {
		JSONObject obj = new JSONObject();
		Class inputClass = null;
		try {
			inputClass = Class.forName(object.getClass().getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method[] methodList = inputClass.getMethods();
		for (Method method : methodList) {
			String methodName = method.getName();
			if(methodName.substring(0, 3).equals("get")&&!methodName.equals("getClass")) {
				String variableName = methodName.substring(3,4).toLowerCase() + methodName.substring(4);
				try {
					obj.put(variableName,method.invoke(object));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				}
			}
		}
		return obj;
	}
}
