package kr.or.kosta.spring.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.spring.employee.domain.Employee;
import lombok.extern.log4j.Log4j;
/**
 * RESTful Service를 위한 RestController = @Controller + @Responsebody
 * @RestController 어노테이션이 적용된  모든 컨트롤러는 view 대신에  특정 자바 객체를 리턴
 * 자바 객체는 메시지 변환 설정에 따라 변환(예: JSON, XML) 
 * @author 김기정
 */
@RestController
@Log4j
public class EmployeeController2 {

     /** 사원목록 */
     @GetMapping(value="/employees", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
     public ResponseEntity<List<Employee>> list() {
          log.info("사원목록 요청");
          List<Employee> list = new ArrayList<Employee>();
          list.add(new Employee(100, "firstName1", "lastName1", "email1"));
          list.add(new Employee(101, "firstName2", "lastName2", "email2"));
          list.add(new Employee(102, "firstName3", "lastName3", "email3"));
          ResponseEntity<List<Employee>> result = ResponseEntity.status(HttpStatus.OK).body(list);
          return result;
     }
     /** 사원상세정보 */
     @GetMapping(value="/employee/{employeeId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
     public ResponseEntity<Employee> read(@PathVariable int employeeId) {
          log.info("사원정보 요청 : " + employeeId);
          Employee employee = new Employee();
          employee.setEmployeeId(employeeId);
          employee.setFirstName("길동");
          employee.setLastName("홍");
          ResponseEntity<Employee> result = ResponseEntity.status(HttpStatus.OK).body(employee);
          return result;
     }
}
