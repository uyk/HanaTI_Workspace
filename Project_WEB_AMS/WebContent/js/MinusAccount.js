/**
 * Account 생성자를 상속받아 마이너스 계좌 정보를 저장하는 생성자. 
 */

function MinusAccount(num,owner,pw,rest, bm) {
	Account.call(this, num, owner, pw, rest);
	this.bm = bm;
}
MinusAccount.prototype = new Account();
delete MinusAccount.prototype.num;
delete MinusAccount.prototype.owner;
delete MinusAccount.prototype.pw;
delete MinusAccount.prototype.rest;
MinusAccount.prototype.constructor = MinusAccount;

// 마이너스 계좌의 내용을 반환하는 메소드
MinusAccount.prototype.toString = function() {
	return Account.prototype.toString.call(this) + " " + this.bm;
}