<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>
	
	<div id="parkContainer">
		<c:forEach var="park" items="${parks}">
			<div class="park">
				<c:url var="parkHref" value="/parkDetail">
					<c:param name="parkCode">${park.parkCode}</c:param>
				</c:url>
				<h3><a href="${parkHref}">${park.parkName} (${park.state})</a></h3>
				<c:url var="parkImgSrc" value="img/parks/${park.parkCode}.jpg" />
				<a href="${parkHref}"><img src="${parkImgSrc}" /></a>
				<p>${park.description}</p>
			</div>	
		</c:forEach>
	</div>

<c:import url ="/WEB-INF/jsp/footer.jsp" />
