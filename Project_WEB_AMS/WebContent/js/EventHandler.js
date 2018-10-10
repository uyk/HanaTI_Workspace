/**
 * AMS의 이벤트를 관리하는 자바스크립트 코드
*/

window.onload = function() {
	init();
	eventRegist();
}

function init() {
	// 초기화 작업
	// AccountManager 생성
	window.am = new AccountManager();
	
}

/** 이벤트 소스에 이벤트 리스너 등록 */
function eventRegist() {
	// 계좌 추가
	document.amsForm.newBt.onclick = add;
	// 전체 계좌 조회
	document.amsForm.allAcc.onclick = list;
	// 계좌번호로 조회
	document.amsForm.sbn.onclick = searchByNumber;
	// 예금주로 조회
	document.amsForm.sbo.onclick = searchByOwner;	
	// 계좌번호로 삭제
	document.amsForm.rm.onclick = remove;
	
}
// AccountManager와 연동하는 함수
// 계좌 등록
function add() {
	// 유효성 검사 추가 필요
	// 계좌번호 유효성 검사
	var accNum = document.amsForm.number.value;
	if(!(isValidNum(accNum))) return false;
	// 예금주명 유효성 검사
	var accOwner = document.amsForm.name.value;
	if(!(isValidOwner(accOwner))) return false;
	
	// 비밀번호 유효성 검사
	var pw = document.amsForm.pw.value;
	if(!(isValidPW(pw))) return false;
	
	// 예금 유효성 검사
	var deposit = document.amsForm.deposit.value;
	if(!(isValidDP(deposit))) return false;
	
	// 계좌 만들어서 추가
	var account = new Account(accNum, accOwner,pw,deposit);
	
	// 추가 실패
	if(!(am.add(account))) {
		alert("이미 존재하는 계좌번호 입니다");
		return false;
	}
	console.log(am);
	// form의 필드 초기화
	document.amsForm.reset();
	// 서버에 제출 안함
	return false;
}

// 전체 계좌 목록을 출력
function list() {
	clearTable();
	var accounts = am.list();
	for ( var i in accounts) {
		console.log(i + " : " + accounts[i]);
		printAcc(accounts[i]);
	}
	console.log(am);
	// form의 필드 초기화
	document.amsForm.reset();
	// 서버에 제출 안함
	return false;
}

// 테이블에 Account 정보 추가
function printAcc(account) {
    var my_tbody = document.getElementById("myTbody");
    var row = my_tbody.insertRow( my_tbody.rows.length ); // 하단에 추가
    var cells = [];
    
    for(var i = 0; i < document.getElementsByTagName('tr')[0].childElementCount; i++) {
    	cells[i] = row.insertCell(i);
    }

    if(account instanceof MinusAccount) {
    	cells[0].innerHTML = "마이너스";
    	cells[4].innerHTML = account.bm;
    }
    else  {
    	cells[0].innerHTML = "입출금";
    }
    
    cells[1].innerHTML = account.num;
    cells[2].innerHTML = account.owner;
    cells[3].innerHTML = account.rest;
}


//테이블 목록 초기화
function clearTable() {
	while (document.getElementsByTagName('tbody')[0].children[0] != undefined) {
		document.getElementsByTagName('tbody')[0].children[0].remove();
	}
}

//계좌 번호로 조회
function searchByNumber() {
	// 유효성 검사 추가 필요
	// 계좌번호 유효성 검사
	var accNum = document.amsForm.number.value;
	if(!(isValidNum(accNum))) return false;

	// 조회 실패
	var result = am.searchByNumber(accNum)
	if(!result) {
		alert("존재하지 않는 계좌번호 입니다.");
		return false;
	}
	
	clearTable();
	printAcc(result);
	
	// form의 필드 초기화
	document.amsForm.reset();
	// 서버에 제출 안함
	return false;
}

// 예금주명으로 조회
function searchByOwner() {
	// 예금주명 유효성 검사
	var accOwner = document.amsForm.name.value;
	if(!(isValidOwner(accOwner))) return false;

	// 조회된 배열을 result에 저장
	var result = am.searchByOwner(accOwner)
	// 조회 실패
	if(!result) {
		alert("존재하지 않는 예금주입니다.");
		return false;
	}
	
	clearTable();
	for ( var i in result) {
		console.log(i + " : " + result[i]);
		printAcc(result[i]);
	}
	console.log(am);
	
	// form의 필드 초기화
	document.amsForm.reset();
	// 서버에 제출 안함
	return false;
}

function remove() {
	// 유효성 검사 추가 필요
	// 계좌번호 유효성 검사
	var accNum = document.amsForm.number.value;
	if(!(isValidNum(accNum))) return false;
	
	// account를 result에 저장
	var result = am.remove(accNum)
	// result가 false면 존재하지 않는 계좌번호
	if(!result) {
		alert("존재하지 않는 계좌번호입니다.");
		return false;
	}
	// 제거 완료 표시
	alert(accNum + '계좌를 제거했습니다.');
	console.log(am);
	// 서버에 제출 안함
	return false;
}


// 유효성 검사 함수
// 계좌번호 유효성 검사
function isValidNum(accNum) {
	if(accNum == null || !(accNum.match(/[0-9]{4}-[0-9]{4}/))){
		alert('계좌번호를 확인해주세요.');
		document.amsForm.number.focus();
		return false; // 디폴트 이벤트핸들러 제거
	}
	return true;
}

// 예금주명 유효성 검사
function isValidOwner(accOwner) {
	if(accOwner == null || !(accOwner.match(/[가-힣a-zA-Z]{1,20}/))){
		alert('예금주를 확인해주세요.');
		document.amsForm.name.focus();
		return false; // 디폴트 이벤트핸들러 제거
	}
	return true;
}

// 비밀번호 유효성 검사
function isValidPW(pw) {
	if(pw == null || !(pw.match(/[0-9]{5,20}/))){
		alert('비밀번호를 확인해주세요.');
		document.amsForm.pw.focus();
		return false; // 디폴트 이벤트핸들러 제거
	}
	return true;
}

// 입금금액 유효성 검사
function isValidDP(dp){
	if(!(dp.match(/[0-9]+/))){
		alert('입금금액을 확인해주세요.');
		document.amsForm.deposit.focus();
		return false; // 디폴트 이벤트핸들러 제거
	}
	return true;
}