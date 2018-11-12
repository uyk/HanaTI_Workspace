<%@ page contentType="text/html; charset=utf-8"%>
<% 
int ammountMoney = Integer.parseInt(request.getParameter("weekday")) * Integer.parseInt(request.getParameter("weekdayPrice")) 
                  + Integer.parseInt(request.getParameter("weekend")) * Integer.parseInt(request.getParameter("weekendPrice"));
%>
<div class='col-xs-6 col-sm-6 col-md-4 col-lg-4' style='margin-bottom: 1em;' data-toggle='modal'
  data-target='#detail_show' data-model-name='<%=request.getParameter("modelName") %>'>
  <div class='tg-populartour'>
    <figure>
      <a><img src="<%=request.getParameter("imgPath") %>" alt='model image'></a>
    </figure>
    
    <div class='tg-populartourcontent'>
      <div class='tg-populartourtitle'>
        <h3>
          <a class='car_detail'><%=request.getParameter("modelName") %></a>
        </h3>
      </div>
      <div class='tg-description' style='height: 150px;'>
        <p><%=request.getParameter("options") %></p>
      </div>
      <div class='tg-populartourfoot' style='height: 70px;'>
        <div class='tg-durationrating'>
          <span class='tg-stars'> 
            <span style='width: <%=request.getParameter("starPercent")%>%'></span>
          </span>
          <em>(<%=request.getParameter("reviewCount") %> Review)</em>
        </div>
        <div class='tg-pricearea'>
          <h4><%= ammountMoney %> &#8361 </h4>
        </div>
      </div>
    </div>
    
  </div>
</div>