package kr.or.kosta.spring.employee.mapper;

import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {
	
//	@Select("Select sysdate from dual")
	public String getTime();
}
