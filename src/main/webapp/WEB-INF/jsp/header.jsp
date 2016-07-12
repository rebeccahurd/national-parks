<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>National Park Geek</title>
		<c:url var="cssHref" value="/css/site.css" />
		<link rel="stylesheet" href="${cssHref}" />
	</head>
	<body>

<div class="header">
	<c:url value="/" var="homePageURL" />
	<a href="${homePageURL}"> 
	    <c:url value="img/logo.png" var="logoURL" />
	    <img src="${logoURL}" id="logo" />
	</a>

    
    <nav>
		<span class="dropbtn"><a href="home">Home</a></span>
		<div class="dropdown">
			<button class="dropbtn">National Parks</button>
			<div class="dropdown-content">
				<c:forEach var="park" items="${parks}">
					<c:url var="parkHref" value="/parkDetail">
						<c:param name="parkCode">${park.parkCode}</c:param>
					</c:url>
					<a href="${parkHref}">${park.parkName}</a>
				</c:forEach>
			</div>
		</div>
		<span class="dropbtn"><a href="survey">Take Our Survey!</a></span>
    </nav>
</div>
   
<div id="content">
    
    <h1><c:out value="${param.pageTitle}" /></h1>
    
    
    