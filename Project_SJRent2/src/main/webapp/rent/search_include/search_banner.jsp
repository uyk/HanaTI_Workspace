<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
         
      <div class="tg-homebannerslider"
         class="tg-homebannerslider tg-haslayout">
         <div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
            <figure class="item"
               data-vide-bg="poster: ../images/slider/img-02.jpg"
               data-vide-options="position: 50% 50%">
               <figcaption>
                  <div class="container">
                     <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                           <form id = "showCarList" class="tg-formtheme tg-formtrip" action="<%=application.getContextPath()%>/model/search.rent" method="get">
                              <fieldset>
                                 <div class="row">
                                    <div class="form-group-row col-md-8">
                                    <div class = "col-md-8">
                                    <input type="text"
                                          id = "datepicker"
                                           data-language="en"
                                           data-range="true"
                                           data-multiple-dates-separator="  ~  "
                                           placeholder="기간을 선택해 주세요"
                                           readonly 
                                           class="datepicker-here form-control" required style="height: 50px" />
                                    </div>
                                    <div class = "col-md-4">
                                       <!-- 총 시간 입력 -->
                                       <input type = "text" id = "total-time" class="form-control" readonly="readonly" style="height: 50px">
                                    </div>
                                    </div>
                                 <div class="form-group col-md-4">
                                    <div class="tg-select" style="padding-left: 15px">
                                       <select class="selectpicker" data-live-search="true"
                                          data-width="100%" title="차종">
                                          <option data-tokens="all">전체</option>
                                          <option data-tokens="ASegment">소형</option>
                                          <option data-tokens="DSegment">중형</option>
                                          <option data-tokens="ESegment">대형</option>
                                          <option data-tokens="JSegment">승합</option>
                                          <option data-tokens="MSegment">SUV</option>
                                          <option data-tokens="SSegment">외제차</option>
                                       </select>
                                    </div>
                                 </div>
                                 <div class="form-group">
                                    <button class="tg-btn" type="submit">
                                       <span>렌트카 찾기</span>
                                    </button>
                                 </div>
                                 </div>
                              </fieldset>
                           </form>
                        </div>
                     </div>
                  </div>
               </figcaption>
            </figure>
         </div>
      </div>