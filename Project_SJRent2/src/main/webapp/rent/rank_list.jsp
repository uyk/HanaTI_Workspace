<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.kosta.sjrent.model.domain.Model"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>

<% 
ArrayList<Model> list = (ArrayList<Model>)request.getAttribute("list");
%>

<div class="col-sm-3 col-md-3 col-lg-3">
	<aside id="tg-sidebar" class="tg-sidebar">
		<div class="tg-widget tg-widgetlatesttour">
			<div class="tg-widgettitle" style="text-align: center;">
				<h3>랭킹</h3>
			</div>
			<div class="clearfix"></div><br><br>
			<div class="tg-widgetcontent">
				<ul>
					<!-- 각 랭킹 모델 정보 -->
                    <%
                    for(int i=0; i<list.size(); i++){
                      Model model = list.get(i);
                    %>
					<li>
						<figure>
							<a href="javascript:void(0);"><img
								src='<%= "../images/cars/" + model.getType() + "/" + model.getPicture() %>' alt="image destinations" style="width: 150px;  height: auto;"></a>
						</figure>
						<div class="tg-newcontent">
							<h4>
								<a href="javascript:void(0);"><%=model.getName() %></a>
							</h4>
							<div class="tg-reviewstararea">
    							<span class='tg-stars'>
                                  <span style='width: <%=model.getEvalScore() * 100 %>%'></span> 
                                </span><br/>
								<em>(<%=model.getReviewCount() %> Review)</em>
							</div>
							<div class="tg-pricearea">
								<span>from</span><br/>
								<h4><%=model.getWeekdayPrice() +"&#8361"%></h4>
                                <p>per day</p>
							</div>
						</div>
					</li>
                    <%
                    }
                    %>
				</ul>
			</div>
		</div>
	</aside>
</div>