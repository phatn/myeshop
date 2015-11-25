<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
    <li data-target="#myCarousel" data-slide-to="5"></li>
    <li data-target="#myCarousel" data-slide-to="6"></li>
    <li data-target="#myCarousel" data-slide-to="7"></li>
    <li data-target="#myCarousel" data-slide-to="9"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
     	 <img alt="Logo" src="<c:url value="/resources/images/banners/1.jpg" />">
    </div>

    <div class="item">
      <img alt="Logo" src="<c:url value="/resources/images/banners/2.jpg" />">
    </div>

    <div class="item">
      <img alt="Logo" src="<c:url value="/resources/images/banners/3.jpg" />">
    </div>

    <div class="item">
       <img alt="Logo" src="<c:url value="/resources/images/banners/4.jpg" />">
    </div>
    
    <div class="item">
       <img alt="Logo" src="<c:url value="/resources/images/banners/5.jpg" />">
    </div>
    
    <div class="item">
       <img alt="Logo" src="<c:url value="/resources/images/banners/6.jpg" />">
    </div>
    
    <div class="item">
       <img alt="Logo" src="<c:url value="/resources/images/banners/7.jpg" />">
    </div>
    
    <div class="item">
       <img alt="Logo" src="<c:url value="/resources/images/banners/8.jpg" />">
    </div>
    
    <div class="item">
       <img alt="Logo" src="<c:url value="/resources/images/banners/9.jpg" />">
    </div>
    
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>