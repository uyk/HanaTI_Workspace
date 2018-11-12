<%@ page contentType="text/html; charset=utf-8" %>
<div class="tg-review">
<span>date: <%=request.getParameter("date") %></span>
	<div class="tg-author">
		<img src="<%=request.getParameter("imgPath") %>"
			alt="image description" style="width: 180px;">
	</div>
	<div class="tg-reviewcontent">
                    <div class="tg-authorinfo" style="display: inline-flex;">
                      <h3 ><%=request.getParameter("userId") %></h3> 
                      <span class="tg-stars" style="margin: 0 10px;">
                        <span style="width: <%=Integer.parseInt(request.getParameter("evalScore")) *10 %>;"></span>
                      </span>
                      <span class="tg-tourduration"><%=request.getParameter("date") %></span>
                    </div>
		<div class="tg-description">
			<p><%=request.getParameter("content") %></p>
		</div>
	</div>
</div>