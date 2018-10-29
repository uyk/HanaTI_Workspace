/**
 * 회원가입 form 필드의 유효성을 검증하는 자바스크립트 코드
*/

window.onload = function() {
	init();
	eventRegist();
}
/** 초기화 작업 */
function init() {

}
/** 이벤트 소스에 이벤트 리스너 등록 */
function eventRegist() {
	// 키가 입력될 때마다 유효성 검사
	document.signUpForm.onkeyup = isValidKey;
}

//키가 입력될 때마다 유효성 검사
function isValidKey(e) {

	var event = e || window.event;
	var source = event.srcElement;
	window.s = source;
	console.log(source.id);
	
	// 비밀번호 일치여부
	if(source.id == "passwd" || source.id == "cpw") {
		checkCPW();
	}
	// 라벨 없는 필드면 함수 종료
	if(source.id == "email" || source.id == "cpw") return false;
	
	// 입력값이 패턴과 일치하지 않으면 라벨을 빨간색으로 표시
	if( source.value == "" || source.validity.patternMismatch ) {
		document.getElementById(s.name+"L").style.color="red";
	}
	// 입력값이 패턴과 일치하면 라벨을 파란색으로 표시
	else {
		document.getElementById(s.name+"L").style.color="blue";
	}
}

// 비밀번호 또는 비밀번호 확인 필드에 값이 입력될 때 일치여부를 검사하여 아이콘 색을 바꾸는 함수
function checkCPW() {
	if(document.getElementById("cpw").value != document.getElementById("passwd").value ){
		document.getElementById("cpwIcon").style.color = "tomato";
		return false;
	}
	else {
		document.getElementById("cpwIcon").style.color = "Dodgerblue";
		return true;
	}
}

// id 중복검사
function validateId() {
	if(document.getElementById("id").reportValidity()){
		var id = document.getElementById("id").value;
		// 존재하지 않는 아이디 
	  window.open("/action/signUpAction.jsp?id="+ document.getElementById("id").value,'validateId','width=300,height=100');
	}
}

// email 중복검사
function validateEmail() {	
	if(document.getElementById("email").reportValidity()){
	  window.open("/action/signUpAction.jsp?email="+ document.getElementById("email").value,'validateId','width=300,height=100');
	}
}

// submit 버튼을 눌렀을 때 비밀번호와 확인필드가 일치하지 않으면 경고
function mySubmit() {
	if(document.getElementById("cpw").value != document.getElementById("passwd").value) {
		alert("비밀번호를 확인해주세요");
		return;
	}
	if(document.signUpForm.reportValidity()){
		document.signUpForm.submit();
	}
}