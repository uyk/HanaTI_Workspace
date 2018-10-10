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
	setValidityMessage();	
	
	// am에 테스트 데이터 추가
	am.add(new Account("1111-2222", "유예겸","12345","5000"));
	am.add(new Account("2222-2222", "유예겸","12345","15000"));
	am.add(new MinusAccount("1111-3333", "김예겸","12345","522000","1000"));
}

/** 이벤트 소스에 이벤트 리스너 등록 */
function eventRegist() {
	// 키가 입력될 때마다 유효성 검사
	document.amsForm.onkeyup = isValidKey;
	// 계좌 타입 선택
	document.amsForm.type.onchange = type;
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
	// 취소 버튼
	document.amsForm.cancelBt.onclick = reset;
	// 입금 버튼
	document.amsForm.depositBt.onclick = deposit;
	// 출금 버튼
	document.amsForm.withdraw.onclick = withdraw;
}

//키가 입력될 때마다 유효성 검사
function isValidKey(e) {
	var event = e || window.event;
	var source = event.srcElement;
	window.s = source;
	// 유효성 검사 대상이 아니면 함수 종료
	if(!(source.validity.customError)) return false;
	
	// 입력값이 패턴과 일치하지 않으면 라벨을 빨간색으로 표시
	if( source.value == "" || source.validity.patternMismatch ) {
		document.getElementById(s.name+"L").style.color="red";
	}
	// 입력값이 패턴과 일치하면 라벨을 파란색으로 표시
	else {
		document.getElementById(s.name+"L").style.color="blue";
	}
}

// 버튼 클릭시 발생하는 유효성 검사 함수
function isValid(src) {
	console.log("1");
	if( (src.value == "" || src.validity.patternMismatch)) {
		console.log("2");
		src.reportValidity();
		setTimeout(function() {
				document.amsForm.deposit.focus();
				src.focus();
			}, 1500);
		return false; 
	}
	return true;
}

// 계좌 타입 선택
function type() {
	if(document.amsForm.type.selectedIndex != 2) {
		document.amsForm.minus.disabled = true;
		document.amsForm.minus.value = "";
	}
	else {
		document.amsForm.minus.disabled = false;
	}
}

// AccountManager와 연동하는 함수
// 계좌 등록
function add() {
	clearTable();
	// 계좌번호 유효성 검사
	var src = document.amsForm.number;
	if(!(isValid(src))) return false;
	var accNum = src.value;
	// 예금주명 유효성 검사
	src = document.amsForm.name;
	if(!(isValid(src))) return false;
	var accOwner = src.value;
	// 비밀번호 유효성 검사
	src = document.amsForm.pw;
	if(!(isValid(src))) return false;
	var pw = src.value;
	// 예금 유효성 검사
	src = document.amsForm.deposit;
	if(!(isValid(src))) return false;
	var deposit = src.value;
	
	// 계좌 타입에 따라 대출금 유효성 검사
	// 마이너스 계좌
	if(document.amsForm.type.selectedIndex == 2) {
		src = document.amsForm.minus;
		if(!(isValid(src))) return false;
		var minus = src.value;
		var account = new MinusAccount(accNum, accOwner,pw,deposit,minus);
		
	}
	// 입출금 계좌
	else {
		var account = new Account(accNum, accOwner,pw,deposit);
	}
	
	// 추가 실패
	if(!(am.add(account))) {
		printMessage("이미 존재하는 계좌번호입니다.");	
		return false;
	}
	// form 초기화
	reset();
	// 서버에 제출 안함
	return false;
}

// 계좌 목록을 출력
function list() {
	clearTable();
	var accounts = am.list(document.amsForm.type.selectedIndex);
	if(accounts.length == 0 ) {
		printMessage("출력할 계좌가 없습니다");
		return false;
	}
	for ( var i in accounts) {
		printAcc(accounts[i]);
	}
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
    document.getElementById("message").innerHTML = "";
	while (document.getElementsByTagName('tbody')[0].children[0] != undefined) {
		document.getElementsByTagName('tbody')[0].children[0].remove();
	}
}

//계좌 번호로 조회
function searchByNumber() {
	clearTable();
	// 계좌번호 유효성 검사
	var src = document.amsForm.number;
	if(!(isValid(src))) return false;
	var accNum = src.value;

	// 조회 실패
	var result = am.searchByNumber(accNum)
	if(!result) {
		printMessage("존재하지 않는 계좌번호입니다.");
		return false;
	}
	
	printAcc(result);

	// form 초기화
	reset();
	// 서버에 제출 안함
	return false;
}

// 예금주명으로 조회
function searchByOwner() {
	clearTable();
	
	// 예금주명 유효성 검사
	src = document.amsForm.name;
	if(!(isValid(src))) return false;
	var accOwner = src.value;
	
	// 조회된 배열을 result에 저장
	var result = am.searchByOwner(accOwner)
	// 조회 실패
	if(!result) {
		printMessage("존재하지 않는 예금주입니다.");
		return false;
	}
	for ( var i in result) {
		printAcc(result[i]);
	}

	// form 초기화
	reset();
	// 서버에 제출 안함
	return false;
}

function remove() {
	// 계좌번호 유효성 검사
	var src = document.amsForm.number;
	if(!(isValid(src))) return false;
	var accNum = src.value;
	
	// account를 result에 저장
	var result = am.remove(accNum)
	// result가 false면 존재하지 않는 계좌번호
	if(!result) {
		printMessage("존재하지 않는 계좌번호입니다.");
		return false;
	}
	// 제거 완료 표시
	printMessage(accNum + " 계좌를 제거했습니다.");
	// 서버에 제출 안함
	return false;
}

// 계좌번호와 비밀번호를 확인해서 입출금
function deposit() {	
	console.log("3");
	clearTable();
	// 계좌번호 유효성 검사
	var src = document.amsForm.number;
	if(!(isValid(src))) return false;
	var accNum = src.value;
	
	// 비밀번호 유효성 검사
	src = document.amsForm.pw;
	if(!(isValid(src))) return false;
	var pw = src.value;
	
	// 입금금액 유효성 검사
	src = document.amsForm.deposit;
	if(!(isValid(src))) return false;
	var deposit = src.value;

	// 조회 실패
	var result = am.searchByNumber(accNum)
	if(!result) {
		printMessage("존재하지 않는 계좌번호입니다.");
		return false;
	}
	// 비밀번호 불일치
	if(!result.checkPasswd(pw)) {
		console.log(pw + " " + result.pw);
		printMessage("비밀번호가 일치하지 않습니다.");
		return false;
	}
	result.deposit(deposit);
	printAcc(result);

}

function withdraw() {
	
}


function setValidityMessage() {
	// 계좌번호 유효성 검사 메시지
	document.amsForm.number.setCustomValidity("0000-0000 형식으로 입력하세요");
	// 예금주명 유효성 검사 메시지
	document.amsForm.name.setCustomValidity("1~20자리 한글 또는 영어만 가능합니다");
	// 비밀번호 유효성 검사 메시지
	document.amsForm.pw.setCustomValidity("5~20자리 숫자를 입력하세요");
	// 예금 유효성 검사 메시지
	document.amsForm.deposit.setCustomValidity("숫자를 입력하세요");	
	// 대출금 유효성 검사 메시지
	document.amsForm.minus.setCustomValidity("숫자를 입력하세요");

}
// form을 초기화하는 함수
function reset() {
	// form의 필드 초기화
	document.amsForm.reset();
	var labels = document.amsForm.getElementsByTagName('label');
	for ( var i = 0; i < labels.length; i++) {
		labels[i].style.color = "black";
	}
}

// 메시지를 출력하는 함수
function printMessage(message) {
	clearTable();
    document.getElementById("message").innerHTML = message;
}