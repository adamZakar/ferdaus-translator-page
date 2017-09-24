<%--
  Created by IntelliJ IDEA.
  User: Ádám
  Date: 2017. 09. 16.
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty param.lang}">
    <c:set var="lang" value="" />
</c:if>
<c:if test="${not empty param.lang}">
    <c:set var="lang" value="?lang=${param.lang}" />
</c:if>
<c:set var="path" value="${pageContext.request.contextPath}"/>;
<!DOCTYPE html>
<html class="no-js">
<head>
    <!-- Basic Page Needs
    ================================================== -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="icon" type="image/png" href="images/favicon.png">
    <title>Timer Agency Template</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    <!-- Mobile Specific Metas
    ================================================== -->
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Template CSS Files
    ================================================== -->
    <!-- Twitter Bootstrs CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <!-- Ionicons Fonts Css -->
    <link rel="stylesheet" href="/resources/css/ionicons.min.css">
    <!-- animate css -->
    <link rel="stylesheet" href="/resources/css/animate.css">
    <!-- Hero area slider css-->
    <link rel="stylesheet" href="/resources/css/slider.css">
    <!-- owl craousel css -->
    <link rel="stylesheet" href="/resources/css/owl.carousel.css">
    <link rel="stylesheet" href="/resources/css/owl.theme.css">
    <link rel="stylesheet" href="/resources/css/jquery.fancybox.css">
    <!-- template main css file -->
    <link rel="stylesheet" href="/resources/css/main.css">
    <!-- responsive css -->
    <link rel="stylesheet" href="/resources/css/responsive.css">

    <!-- Template Javascript Files
    ================================================== -->
    <!-- modernizr js -->
    <script src="/resources/js/vendor/modernizr-2.6.2.min.js"></script>
    <!-- jquery -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- owl carouserl js -->
    <script src="/resources/js/owl.carousel.min.js"></script>
    <!-- bootstrap js -->

    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- wow js -->
    <script src="/resources/js/wow.min.js"></script>
    <!-- slider js -->
    <script src="/resources/js/slider.js"></script>
    <script src="/resources/js/jquery.fancybox.js"></script>
    <!-- template main js -->
    <script src="/resources/js/main.js"></script>
    <script src="/resources/js/contact.js"></script>
</head>
<body>
<!--
==================================================
Header Section Start
================================================== -->
<header id="top-bar" class="navbar-fixed-top animated-header">
    <div class="container">
        <div class="navbar-header">
            <!-- responsive nav button -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- /responsive nav button -->

            <!-- logo -->
            <div class="navbar-brand">
                <a href="index.html" >
                    <img src="/resources/images/logo.png" alt="">
                </a>
            </div>
            <!-- /logo -->
        </div>
        <!-- main menu -->
        <nav class="collapse navbar-collapse navbar-right" role="navigation">
            <div class="main-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${languages}"></c:out> <span class="caret"></span></a>
                        <div class="dropdown-menu">
                            <ul>
                                <li><a href="${path}/contact"> <img src="resources/images/hu.jpg" width=20px"/> MAGYAR </a></li>
                                <li><a href="${path}/contact?lang=en"> <img src="resources/images/en.jpg" width=20px/> ENGLISH </a></li>
                                <li><a href="${path}/contact?lang=pa"> <img src="resources/images/pa.jpg" width=20px/> PASTU </a></li>
                                <li><a href="${path}/contact?lang=pe"> <img src="resources/images/pe.jpg" width=20px/> PERSIAN </a></li>
                                <li><a href="${path}/contact?lang=ur"> <img src="resources/images/ur.jpg" width=20px/> URDU </a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="${path}/home${lang}"> <c:out value="${home}"></c:out> </a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${services}"></c:out> <span class="caret"></span></a>
                        <div class="dropdown-menu">
                            <ul>
                                <li><a href="${path}/translation${lang}"> <c:out value="${translation}"></c:out> </a></li>
                                <li><a href="${path}/interpretition${lang}"><c:out value="${interpretition}"></c:out></a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="${path}/contact${lang}"><c:out value="${contact}"></c:out></a></li>
                </ul>
            </div>
        </nav>
        <!-- /main nav -->
    </div>
</header>

<!--
==================================================
    Global Page Section Start
================================================== -->
<section class="global-page-header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block">
                    <h2><c:out value="${contact}"></c:out></h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="${path}/home${lang}">
                                <i class="ion-ios-home"></i>
                                <c:out value="${home}"></c:out>
                            </a>
                        </li>
                        <li class="active"><c:out value="${contact}"></c:out></li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</section><!--/#page-header-->


<!--
==================================================
    Contact Section Start
================================================== -->
<section id="contact-section">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="block">
                    <h2 class="subtitle wow fadeInDown" data-wow-duration="500ms" data-wow-delay=".3s">Contact With Me</h2>
                    <p class="subtitle-des wow fadeInDown" data-wow-duration="500ms" data-wow-delay=".5s">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore, ea!
                        consectetur adipisicing elit. Dolore, ea!
                    </p>
                    <div class="contact-form">
                        <form id="contact-form" onsubmit="return onsub()">

                            <div class="form-group wow fadeInDown" data-wow-duration="500ms" data-wow-delay=".6s">
                                <input type="text" placeholder="Your Name" class="form-control" name="name" id="name" >
                            </div>

                            <div class="form-group wow fadeInDown" data-wow-duration="500ms" data-wow-delay=".8s" >
                                <input type="email" placeholder="Your Email" class="form-control" name="email" id="email" >
                            </div>

                            <div class="form-group wow fadeInDown" data-wow-duration="500ms" data-wow-delay="1s">
                                <input type="text" placeholder="Subject" class="form-control" name="subject" id="subject">
                            </div>

                            <div class="form-group wow fadeInDown" data-wow-duration="500ms" data-wow-delay="1.2s">
                                <textarea rows="6" placeholder="Message" class="form-control" name="message" id="message"></textarea>
                            </div>


                            <div id="submit" class="wow fadeInDown" data-wow-duration="500ms" data-wow-delay="1.4s">
                                <input type="submit" id="contact-submit" class="btn btn-default btn-send" value="Send Message">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="map-area">
                    <h2 class="subtitle  wow fadeInDown" data-wow-duration="500ms" data-wow-delay=".3s">Find Us</h2>
                    <p class="subtitle-des wow fadeInDown" data-wow-duration="500ms" data-wow-delay=".5s">
                        Si aute quis eu proident o cupidatat ne anim nescius, et est praesentibus, o quorum vidisse expetendis, nostrud eram quibusdam ad nam nostrud ubi.

                    </p>
                    <div class="map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3651.277552998015!2d90.3678744!3d23.773128800000002!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3755c0ae4adf3cb9%3A0x7f2cf443b764e4a4!2sShishu+Mela!5e0!3m2!1sen!2s!4v1435516022247" width="100%" height="400" frameborder="0" style="border:0" allowfullscreen></iframe>

                    </div>
                </div>
            </div>
        </div>
        <div class="row address-details">
            <div class="col-md-3">
                <div class="address wow fadeInLeft" data-wow-duration="500ms" data-wow-delay=".3s">
                    <i class="ion-ios-location-outline"></i>
                    <h5>125 , Kings Street,Melbourne <br>United Kingdom,600562</h5>
                </div>
            </div>
            <div class="col-md-3">
                <div class="address wow fadeInLeft" data-wow-duration="500ms" data-wow-delay=".5s">
                    <i class="ion-ios-location-outline"></i>
                    <h5>125 , Kings Street,Melbourne <br>United Kingdom,600562</h5>
                </div>
            </div>
            <div class="col-md-3">
                <div class="email wow fadeInLeft" data-wow-duration="500ms" data-wow-delay=".7s">
                    <i class="ion-ios-email-outline"></i>
                    <p>support@themefisher.com<br>support@themefisher.com</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="phone wow fadeInLeft" data-wow-duration="500ms" data-wow-delay=".9s">
                    <i class="ion-ios-telephone-outline"></i>
                    <p>+07 052 245 022<br>+07 999 999 999</p>
                </div>
            </div>
        </div>
    </div>
</section>






<!--
==================================================
    Call To Action Section Start
================================================== -->
<section id="call-to-action">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block">
                    <h2 class="title wow fadeInDown" data-wow-delay=".3s" data-wow-duration="500ms">INTERESTED IN WORKING TOGETHER? ?</h2>
                        <p class="wow fadeInDown" data-wow-delay=".5s" data-wow-duration="500ms">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nobis,</br>possimus commodi, fugiat magnam temporibus vero magni recusandae? Dolore, maxime praesentium.</p>
                        <a href="contact.html" class="btn btn-default btn-contact wow fadeInDown" data-wow-delay=".7s" data-wow-duration="500ms">Contact With Me</a>
                </div>
            </div>

        </div>
    </div>
</section>


<!--
==================================================
    Footer Section Start
================================================== -->
<footer id="footer">
    <div class="container">
        <div class="col-md-8">
            <p class="copyright">Copyright: <span>2015</span> . Design and Developed by <a href="http://www.Themefisher.com">Themefisher</a></p>
        </div>
        <div class="col-md-4">
            <!-- Social Media -->
            <ul class="social">
                <li>
                    <a href="#" class="Facebook">
                        <i class="ion-social-facebook"></i>
                    </a>
                </li>
                <li>
                    <a href="#" class="Twitter">
                        <i class="ion-social-twitter"></i>
                    </a>
                </li>
                <li>
                    <a href="#" class="Linkedin">
                        <i class="ion-social-linkedin"></i>
                    </a>
                </li>
                <li>
                    <a href="#" class="Google Plus">
                        <i class="ion-social-googleplus"></i>
                    </a>
                </li>

            </ul>
        </div>
    </div>
</footer> <!-- /#footer -->

</body>
</html>



