<%@ page contentType="text/html; charset=utf-8" %>
<div class="modal fade" id="choose-from-my-photo">
  <div class="modal-dialog ui-block window-popup choose-from-my-photo">
    <a href="#" class="close icon-close" data-dismiss="modal" aria-label="Close">
      <svg class="olymp-close-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-close-icon"></use></svg>
    </a>

    <div class="ui-block-title">
      <h6 class="title">Choose from My Photos</h6>

      <!-- Nav tabs -->
      <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
          <a class="nav-link active" data-toggle="tab" href="#home" role="tab" aria-expanded="true">
            <svg class="olymp-photos-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-photos-icon"></use></svg>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="tab" href="#profile" role="tab" aria-expanded="false">
            <svg class="olymp-albums-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-albums-icon"></use></svg>
          </a>
        </li>
      </ul>
    </div>


    <div class="ui-block-content">
      <!-- Tab panes -->
      <div class="tab-content">
        <div class="tab-pane active" id="home" role="tabpanel" aria-expanded="true">

          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo1.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo2.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo3.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>

          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo4.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo5.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo6.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>

          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo7.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo8.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo9.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>


          <a href="#" class="btn btn-secondary btn-lg btn--half-width">Cancel</a>
          <a href="#" class="btn btn-primary btn-lg btn--half-width">Confirm Photo</a>

        </div>
        <div class="tab-pane" id="profile" role="tabpanel" aria-expanded="false">

          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo10.jpg" alt="photo">
              <figcaption>
                <a href="#">South America Vacations</a>
                <span>Last Added: 2 hours ago</span>
              </figcaption>
            </figure>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo11.jpg" alt="photo">
              <figcaption>
                <a href="#">Photoshoot Summer 2016</a>
                <span>Last Added: 5 weeks ago</span>
              </figcaption>
            </figure>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo12.jpg" alt="photo">
              <figcaption>
                <a href="#">Amazing Street Food</a>
                <span>Last Added: 6 mins ago</span>
              </figcaption>
            </figure>
          </div>

          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo13.jpg" alt="photo">
              <figcaption>
                <a href="#">Graffity & Street Art</a>
                <span>Last Added: 16 hours ago</span>
              </figcaption>
            </figure>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo14.jpg" alt="photo">
              <figcaption>
                <a href="#">Amazing Landscapes</a>
                <span>Last Added: 13 mins ago</span>
              </figcaption>
            </figure>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo15.jpg" alt="photo">
              <figcaption>
                <a href="#">The Majestic Canyon</a>
                <span>Last Added: 57 mins ago</span>
              </figcaption>
            </figure>
          </div>


          <a href="#" class="btn btn-secondary btn-lg btn--half-width">Cancel</a>
          <a href="#" class="btn btn-primary btn-lg disabled btn--half-width">Confirm Photo</a>
        </div>
      </div>
    </div>

  </div>
</div>
