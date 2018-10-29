<!DOCTYPE html>
<html>
<head>
<title>회원가입 연습 화면</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">

  <!-- Page content -->
  <div class="w3-content">
    <div class="w3-container" id="contact">
      <h2>회원가입</h2>
      <p>※ 좋은 것 서비스 받을려면 회원가입혀~~^^</p>
      <form>
        <p>
          <input class="w3-input w3-padding-16 w3-border" type="text"
            placeholder="아이디" required name="id">
        </p>
        <p>
          <input class="w3-input w3-padding-16 w3-border" type="text"
            placeholder="이름" required name="name">
        </p>
        <p>
          <input class="w3-input w3-padding-16 w3-border"
            type="password" placeholder="비밀번호" required name="passwd">
        </p>
        <p>
          <input class="w3-input w3-padding-16 w3-border" type="text"
            placeholder="이메일" required name="email">
        </p>
        <p>
          <input class="w3-input w3-padding-16 w3-border" type="text"
            placeholder="남기고 싶은 말" name="message">
        </p>
        <p>
          <button class="w3-button w3-red w3-padding-large"
            type="submit">가입하기</button>
          <button class="w3-button w3-blue w3-padding-large"
            type="reset">취소하기</button>
        </p>
      </form>
    </div>

  </div>

  <footer class="w3-padding-32 w3-black w3-center w3-margin-top">
    <p>
      Powered by <a href="http://edu.kosta.or.kr" target="_blank"
        class="w3-hover-text-green">bangry.com</a>
    </p>
  </footer>

</body>
</html>