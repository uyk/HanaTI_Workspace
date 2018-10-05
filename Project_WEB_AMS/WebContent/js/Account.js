/**
 *  계좌 정보를 저장하는 Account 생성자
 */

// 생성자
function Account(num,owner,pw,rest) {
	this.num = num;
	this.owner = owner;
	this.pw = pw;
	this.rest = rest;
}

// Account의 모든 인스턴스가 공유하는 변수
Account.bankName = "KOSTA 은행";

// Account의 prototype에 메소드 선언
// 입금시 money만큼 잔액이 증가하는 메소드
Account.prototype.deposit = function(money) {
	if(money <= 0) return false;
	this.rest += money;
	return this.rest;
}
// 출금시 money만큼 잔액이 감소하는 메소드
Account.prototype.withdraw = function(money) {
	if(money <= 0) return false;
	if(money > this.rest) return false;
	this.rest -= money;
	return this.rest;
}
// 패스워드를 검사하는 메소드
Account.prototype.checkPasswd = function (pw) {
	return this.pw == pw;
}
// 계좌 정보를 문자열로 반환하는 메소드
Account.prototype.toString = function() {
	return Account.bankName + " " + this.num + " " + this.owner + " " + this.pw + " " + this.rest;
}
