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
	height: auto;
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
.label
{
	font-size: 20px;
	color: red;
}
</style>

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-animate.js"></script>
<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.14.2.js"></script>
<spring:url value="/resources/core/js/signup.js" var="signupJs" />
<spring:url value="/resources/core/js/select2.js" var="selectJs" />
<script src="${selectJs}"></script>
<script src="${signupJs}"></script>
</head>

<body ng-init="param='${email}'">
<div ng-controller="profileCtrl" />

	 <script type="text/ng-template" id="myModalContent.html">
        <div class="modal-header">
            <h3 class="modal-title">Add a class to watch</h3>
        </div>
        <div class="modal-body">
			Class
			<select id="classSel" class="form-control" ng-model="item" placeholder="Select a class">
				<option ng-repeat="item in classes"> {{item}} </option>
			</select>
			</br>
			Section
			<select id="crnSel" class="form-control" ng-model="crn" placeholder="Select a section">
				<option ng-repeat="crn in crns"> {{crn}} </option>
			</select>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="ok(item, crn)">OK</button>
            <button class="btn btn-warning" type="button" ng-click="cancel(); ">Cancel</button>
        </div>
    </script>
    
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
			<a class="navbar-brand" href="">ClassMe</a>
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
			<h2>User Profile</h2>
			<form role="form">
				<div class="col-lg-6">
					</br>
					<div class="form-group">
						<label class ="label">UserName</label>
						<div>
							<h5>
								   &nbsp&nbsp&nbsp{{user.name}}
							</h5>
						</div>
					</div>
					<div class="form-group">
						<label class ="label">Email</label>
						<div>
							<h5>
								 &nbsp&nbsp&nbsp{{user.email}}	
							</h5>
						</div>
					</div>
					<div class="form-group">
						<label class ="label">Description</label>
						<div>
							<h5>
								&nbsp&nbsp&nbsp{{user.description}}
							</h5>
						</div>
					</br></br>
						<div class="input-group">
							<input  id="inputDesc"  class="form-control" ng-model="inputDesc" placeholder="Update Description" required=""> 
						</div>
					</div>					
					<button class="btn btn-info pull-left" type="submit" ng-click= "updateDesc(inputDesc)">Update</button>
					<!--  <input type="submit" name="submit" id="submit" value="Submit" ng-click = "checkAndSignup(inputName, inputEmail, inputPW, inputPWC)"
						class="btn btn-info pull-right">-->
				</div>

				<div class="col-lg-6">
					<div class="form-group">
						</br>
						<label class ="label">Courses on watch</label>
						<br/><br/><br/>
						
					<div id="tb" class="inner cover" data-spy="scroll"
					data-target="#myScrollspy" data-offset="10">
					<table class="table ">
						<tr>
							<td><b>Course Number</b></td>
							<td><b>Section</b></td>
							<td><b>Status</b></td>
							<td><b>Unwatch</b></td>
						</tr>
						<tr ng-repeat="y in courses | limitTo:quantity">
							<td>{{y.courseNum}}</td>
							<td>{{y.section}}</td>
							<td ng-class="{'red': y.status == 'Closed','green': y.status == 'Open'}">{{y.status}}</td>
							<td><button type="button" class="btn btn-danger" ng-click="deleteWatch(y.courseNum, y.section)">Delete</button></td>
						</tr>

					</table>
				</div>
						
						
					</div>
										
					<button type="button" class="btn btn-info pull-left" ng-click="open()">Add Class</button>
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
</body>
</html>