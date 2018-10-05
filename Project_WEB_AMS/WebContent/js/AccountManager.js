/**
 * Account와 MinusAccount 계좌들의 정보를 관리하는 AccountManager
 * AccountManager가 하나만 필요할 경우 객체로 정의해도 되지만
 * 다수의 Manager가 필요할 수 있기 때문에 생성자로 구현한다.
 */

function AccountManager() {
	this.accounts = [];
}

// accounts에 계좌를 추가.
AccountManager.prototype.add = function(account) {
	// account의 계좌번호로 이미 존재하는 계좌인지 검사
	if(this.searchByNumber(account.num)) {
		return false;
	}
	// 존재하지 않을 경우 추가
	this.accounts.push(account);
	return true;
}
// accounts에서 계좌번호를 계좌를 조회
AccountManager.prototype.searchByNumber = function(num) {
	for ( var i in this.accounts) {
		if((this.accounts[i]).num == num) 
			return this.accounts[i];
	}
	return false;
}
// accounts에서 예금주명으로 계좌목록을 검색하여 반환
AccountManager.prototype.searchByOwner = function(owner) {
	var tempA = [];
	for ( var i in this.accounts) {
		if((this.accounts[i]).owner == owner) 
			tempA.push(this.accounts[i]);
	}
	return tempA;
}
// accounts에서 계좌번호로 해당계좌를 제거
AccountManager.prototype.remove = function(num) {
	for ( var i in this.accounts) {
		if((this.accounts[i]).num == num) {
			return this.accounts.splice(i, 1);
		}
	}
	return false;
}
// accounts를 문자열로 반환
AccountManager.prototype.toString = function() {
	var string = "";
	for ( var i in this.accounts) {
		string += i + " : " + this.accounts[i].toString() + "\n";
	}
	return string;
}