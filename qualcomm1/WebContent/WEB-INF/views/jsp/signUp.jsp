<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0040)http://getbootstrap.com/examples/signin/ -->
<html lang="en"  ng-app="ui.bootstrap.demo">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<link rel="icon"
	href="http://www.centralmaine.com/wp-content/uploads/2015/02/cm-icon-blackForSharing.png">
<title>ClassMe</title>

<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/examples/signin/signin.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="./Signin Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


<style>
#content {
	background-image:
		url("http://wallpoper.com/images/00/31/33/51/black-background_00313351.jpg");
	//
	background-image: url('contentBackground.jpg');
	height: 100%;
	padding-top: 100px;
	padding-bottom: 250px;
}

#navigator {
	background-image:
		url("http://imperialdesignfl.com/wp-content/uploads/2015/01/Black-Background-Design-Wallpaper-Widescreen1.jpg");
	//
	background-image: url('navigatorBackground.jpg');
	width: 100%;
}

#footer {
	background-image:
		url("http://wallpoper.com/images/00/31/33/51/black-background_00313351.jpg");
	//
	background-image: url('contentBackground.jpg');
	width: 100%;
}

.input-group {
	width: 100%
}
</style>

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-animate.js"></script>
<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.14.2.js"></script>
<spring:url value="/resources/core/js/signup.js" var="signupJs" />
<script src="${signupJs}"></script>
</head>

<body ng-controller="SignupCtrl" >

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container" id="navigator">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="">Temperature</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden active"><a href=""></a></li>
				<li class="page-scroll"><a href="#">About</a></li>
				<li class="page-scroll"><a href="#">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<section class="bg-primary" id="content">
	<div class="container center-block">
		<div class="row">
			<form role="form">
				<div class="col-lg-6 col-lg-offset-3">
					<h2>SignUp Page</h2>
					</br>
					<div class="form-group">
						<label for="InputName">Enter Name</label>
						<div class="input-group">
							<input type="text" class="form-control" ng-model = "inputName" name="InputName"
								id="InputName" placeholder="Enter Name" required>
						</div>
					</div>
					<div class="form-group">
						<label for="InputEmail">Enter Email</label>
						<div class="input-group">
							<input type="email" class="form-control" ng-model = "inputEmail" id="InputEmail"
								name="InputEmail" placeholder="Enter Email" required>
						</div>
					</div>
					<div class="form-group">
						<label for="InputEmail">Enter Password</label>
						<div class="input-group">
							<input type="password" class="form-control" ng-model = "inputPW" id="InputPasswordFirst"
								name="InputPassword" placeholder="Enter Password" required>
						</div>
					</div>
					<div class="form-group">
						<label for="InputEmail">Confirm Password</label>
						<div class="input-group">
							<input type="password" class="form-control" ng-model = "inputPWC" id="InputPasswordSecond"
								name="InputPassword" placeholder="Confirm Password" required>
						</div>
					</div>
					<div>
						<label class = "label label-danger" id ="pwWarning" ng-show="inputPW!=inputPWC" ng-hide="inputPWC==inputPW">
							Passwords are not the same!
						</label>
					</div>
					<input type="submit" name="submit" id="submit" value="Submit" ng-click = "checkAndSignup(inputName, inputEmail, inputPW, inputPWC)"
						class="btn btn-info pull-right">
				</div>
			</form>

		</div>
	</div>
	</section>
	<footer id="footer">
	<div class="container">
		<hr>
		<p>
			<small><a href="http://facebook.com">Like ClassMe</a> On
				facebook</small>
		</p>
		<p>
			<small><a href="http://twitter.com">Follow ClassMe</a> On
				Twitter</small>
		</p>
	</div>
	</footer>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="./Signin Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>


</body>
</html>