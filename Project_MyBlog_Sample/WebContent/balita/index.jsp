<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <%--헤드 시작--%>
    <jsp:include page="include/head.jsp"></jsp:include>
    <%--헤드 종료--%>
  </head>
  
  <body>
    <%--탑 메뉴 시작--%>
    <jsp:include page="include/header.jsp"></jsp:include>
    <%--탑 메뉴 종료--%>

    <section class="site-section pt-5">
      <div class="container">
        <div class="row">
          <div class="col-md-12">

            <div class="owl-carousel owl-theme home-slider">
            
              <div>
                <a href="blog-single.html" class="a-block d-flex align-items-center height-lg" style="background-image: url('images/img_1.jpg'); ">
                  <div class="text half-to-full">
                    <div class="post-meta">
                      <span class="category">Lifestyle</span>
                      <span class="mr-2">March 15, 2018 </span> &bullet;
                      <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                    </div>
                    <h3>Thereâs a Cool New Way for Men to Wear Socks and Sandals</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem nobis, ut dicta eaque ipsa laudantium!</p>
                  </div>
                </a>
              </div>
              <div>
                <a href="blog-single.html" class="a-block d-flex align-items-center height-lg" style="background-image: url('images/img_2.jpg'); ">
                  <div class="text half-to-full">
                    <div class="post-meta">
                      <span class="category">Lifestyle</span>
                      <span class="mr-2">March 15, 2018 </span> &bullet;
                      <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                    </div>
                    <h3>Thereâs a Cool New Way for Men to Wear Socks and Sandals</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem nobis, ut dicta eaque ipsa laudantium!</p>
                  </div>
                </a>
              </div>
              <div>
                <a href="blog-single.html" class="a-block d-flex align-items-center height-lg" style="background-image: url('images/img_3.jpg'); ">
                  <div class="text half-to-full">
                    <div class="post-meta">
                      <span class="category">Lifestyle</span>
                      <span class="mr-2">March 15, 2018 </span> &bullet;
                      <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                    </div>
                    <h3>Thereâs a Cool New Way for Men to Wear Socks and Sandals</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem nobis, ut dicta eaque ipsa laudantium!</p>
                  </div>
                </a>
              </div>
              
            </div>
            
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 col-lg-4">
            <a href="blog-single.html" class="a-block d-flex align-items-center height-md" style="background-image: url('images/img_2.jpg'); ">
              <div class="text">
                <div class="post-meta">
                  <span class="category">Lifestyle</span>
                  <span class="mr-2">March 15, 2018 </span> &bullet;
                  <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                </div>
                <h3>Thereâs a Cool New Way for Men to Wear Socks and Sandals</h3>
              </div>
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a href="blog-single.html" class="a-block d-flex align-items-center height-md" style="background-image: url('images/img_3.jpg'); ">
              <div class="text">
                <div class="post-meta">
                  <span class="category">Travel</span>
                  <span class="mr-2">March 15, 2018 </span> &bullet;
                  <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                </div>
                <h3>Thereâs a Cool New Way for Men to Wear Socks and Sandals</h3>
              </div>
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a href="blog-single.html" class="a-block d-flex align-items-center height-md" style="background-image: url('images/img_4.jpg'); ">
              <div class="text">
                <div class="post-meta">
                  <span class="category">Food</span>
                  <span class="mr-2">March 15, 2018 </span> &bullet;
                  <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                </div>
                <h3>Thereâs a Cool New Way for Men to Wear Socks and Sandals</h3>
              </div>
            </a>
          </div>
        </div>
      </div>
    </section>
    <!-- END section -->
    <%--FOOTER 시작--%>
    <jsp:include page="include/footer.jsp"></jsp:include>
    <%--FOOTER 종료--%>
    
    <!-- loader -->
    <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#f4b214"/></svg></div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-migrate-3.0.0.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.stellar.min.js"></script>

    
    <script src="js/main.js"></script>
  </body>
</html>