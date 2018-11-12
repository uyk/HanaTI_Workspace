<%@ page contentType="text/html; charset=utf-8"%>
<% 
int ammountMoney = Integer.parseInt(request.getParameter("weekday")) * Integer.parseInt(request.getParameter("weekdayPrice")) 
                  + Integer.parseInt(request.getParameter("weekend")) * Integer.parseInt(request.getParameter("weekendPrice"));
%>
<div class='col-xs-6 col-sm-6 col-md-4 col-lg-4'   style='margin-bottom: 1em;' data-toggle='modal'
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
      <div class='tg-populartourfoot'>
        <div class='tg-durationrating'>
          <span class='tg-tourduration tg-availabilty'> 
            weekday : <%=request.getParameter("weekdayPrice") %> &#8361<br/>
            weekend : <%=request.getParameter("weekendPrice") %> &#8361<br/>
          </span>
          <span class='tg-stars'> 
            <span style='width: <%=request.getParameter("starPercent")%>%'></span>
          </span>
          <em>(<%=request.getParameter("reviewCount") %> Review)</em>
        </div>
        <div class='tg-pricearea'>
          <h4><%= ammountMoney %></h4>
        </div>
      </div>
    </div>
    
  </div>
</div>