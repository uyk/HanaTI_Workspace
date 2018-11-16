package kr.or.kosta.spring.sample.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * POJO(Java Bean)
 * @author 유예겸
 *
 */
@Component("chef")
@Scope("prototype")
public class Chef {
	@Value("김기정")
	private String name;

	public Chef() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chef(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Chef [name=" + name + "]";
	}
	
}
