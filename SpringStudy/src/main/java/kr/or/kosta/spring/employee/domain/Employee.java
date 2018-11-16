package kr.or.kosta.spring.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
}
