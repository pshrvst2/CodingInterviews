<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0040)http://getbootstrap.com/examples/cover/# -->
<html lang="en" ng-app="ui.bootstrap.demo">

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

<title>Temperature</title>

<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/examples/cover/cover.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="./Cover Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
.site-wrapper { //
	background-image: url('contentBackground.jpg');
	background-image:
		url("http://wallpoper.com/images/00/31/33/51/black-background_00313351.jpg");
}

#navigator { //
	background-image: url('navigatorBackground.jpg');
	background-image:
		url("http://imperialdesignfl.com/wp-content/uploads/2015/01/Black-Background-Design-Wallpaper-Widescreen1.jpg");
	width: 100%;
}

#tb {
	margin-top: 5em;
}
</style>


<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-animate.js"></script>
<script
	src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.14.2.js"></script>
<spring:url value="/resources/core/js/temp.js" var="tempJs" />
<script src="${tempJs}"></script>
</head>

<body ng-controller=temp_2Ctrl>

	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="cover-container">

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
						<a class="navbar-brand" href="">Temperature Section 2</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
							<li class="hidden active"><a href=""></a></li>
							<li class="page-scroll"><a href="http://localhost:8080/qualcomm/">Go to Section 1</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>

				<div id="tb" class="inner cover" data-spy="scroll"
					data-target="#myScrollspy" data-offset="20">
					<table class="table ">
						<tr>
							<td><b>Country Name</b></td>
							<td><b>Amount of City Under the Temperature Range</b></td>
		
						</tr>
						<tr ng-repeat="x in rawData">
							<td>{{x.name}}</td>
							<td>{{x.cityCount}}</td>
						</tr>

					</table>
				</div>
               <div>
               	<h2> Enter the Range </h2>
               	<div class="form-group">
	                <div class="controls">
	                  <input type="text" data-ng-model="inputMax" id="title" class="form-control" placeholder="Max temp" required>
	                </div>
	            </div>
	            <div class="form-group">
	                <div class="controls">
	                  <input type="text" data-ng-model="inputMin" id="title" class="form-control" placeholder="Min temp" required>
	                </div>
	            </div>
				<div>
					<button class="btn btn-lg btn-primary btn-block" type="submit" ng-click= "checkAndgetInfo(inputMin, inputMax)">Get the Country info</button>
				</div>	
			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="./Cover Template for Bootstrap_files/jquery.min.js"></script>
	<script src="./Cover Template for Bootstrap_files/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="./Cover Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>


</body>
</html>