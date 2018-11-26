package kr.or.kosta.spring.employee.command;

import lombok.Data;

@Data
public class LoginCommand {
    private String userId;
    private String password;
    private boolean rememberId;
    
    public LoginCommand() {
         super();
    }
    public LoginCommand(String userId, String password, boolean rememberId) {
         super();
         this.userId = userId;
         this.password = password;
         this.rememberId = rememberId;
    }

}
