<%@ page contentType="text/html; charset=utf-8" %>
<div class="modal fade" id="update-header-photo">
  <div class="modal-dialog ui-block window-popup update-header-photo">
    <a href="#" class="close icon-close" data-dismiss="modal" aria-label="Close">
      <svg class="olymp-close-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-close-icon"></use></svg>
    </a>

    <div class="ui-block-title">
      <h6 class="title">Update Header Photo</h6>
    </div>

    <a href="#" class="upload-photo-item">
      <svg class="olymp-computer-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-computer-icon"></use></svg>
      <h6>Upload Photo</h6>
      <span>Browse your computer.</span>
    </a>

    <a href="#" class="upload-photo-item" data-toggle="modal" data-target="#choose-from-my-photo">
      <svg class="olymp-photos-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-photos-icon"></use></svg>
      <h6>Choose from My Photos</h6>
      <span>Choose from your uploaded photos</span>
    </a>
  </div>
</div>