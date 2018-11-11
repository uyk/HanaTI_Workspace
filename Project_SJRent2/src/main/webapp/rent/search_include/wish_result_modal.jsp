<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<!-- Modal -->
<div class="modal fade" id="wish_result_modal" tabindex="-1" role="dialog" aria-labelledby="wish_result_modal-title" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="wish_result_modal-title">위시리스트에 담기</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id='wish_result_modal_body'>
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="location.href='<%=application.getContextPath()%>/wishitem/list.rent'">Go Wish List</button>
        <button type="button" class="btn btn-secondary" onclick="wishResultHide()">Not now</button>
      </div>
    </div>
  </div>
</div>