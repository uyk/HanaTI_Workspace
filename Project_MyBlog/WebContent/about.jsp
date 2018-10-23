<%-- 블로그 정보를 출력하는 페이지 --%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <%--헤드 시작--%>
    <jsp:include page="/include/head.jsp"></jsp:include>
    <%--헤드 종료--%>
  </head>
  <body>
    <%--탑 메뉴 시작--%>
    <jsp:include page="/include/header.jsp"></jsp:include>
    <%--탑 메뉴 종료--%>
    
    <section class="site-section">
      <div class="container">
        
        <div class="row blog-entries">
        
          <div class="col-md-12 col-lg-8 main-content">
            <div class="row">
            	<h2 class="mb-4">Hi There! I'm Yegyeom Yu</h2>
           	</div>
            <div class="row">
              <div class="col-md-6">
                <img src="/images/uyk3.jpg" alt="Image placeholder" class="img-fluid">
              </div>
              <div class="col-md-6">
                <p>안녕하세요&nbsp;<i class="far fa-grin-squint"></i>&nbsp;블로그에 온걸 환영합니다! 자유롭게 가입하고 게시글을 남겨주세요. 공지사항을 자주 확인해주세요<br/>&nbsp;<i class="fas fa-exclamation-triangle"></i>&nbsp;게시판에 맞지 않는 글은 삭제될 수 있습니다.</p>
                <br/>
                <p>Hi There! &nbsp;<i class="far fa-grin-squint"></i>&nbsp;This is UYK's blog about traveling<i class="fas fa-plane"></i>  Welcome to my blog! Feel free to sing up and write a post on my blog. <br/>&nbsp;<i class="fas fa-exclamation-triangle"></i>&nbsp;Be careful! Improper posts may be deleted by administrator.</p>
                <br/>
                <p> こんにちは！これは、旅行に関するUYKのブログです。私のブログへようこそ！私のブログには、お気軽にお立ち寄りください。  注意してください！不適切な投稿は管理者によって削除されることがあります</p>
              </div>
            </div>
          </div>
          <!-- END main-content -->
          <%--사이드 시작--%>
          <jsp:include page="/include/side.jsp"></jsp:include>
          <%--사이드 종료--%>
          
        </div>
      </div>
    </section>
  
    <%--FOOTER 시작--%>
    <jsp:include page="/include/footer.jsp"></jsp:include>
    <%--FOOTER 종료--%>
    
    <%-- LOADER 시작--%>
    <jsp:include page="/include/loader.jsp"></jsp:include>
    <%-- LOADER 종료--%>
  </body>
</html>