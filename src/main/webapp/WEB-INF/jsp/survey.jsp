<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

<c:choose>
	<c:when test='${completedSurvey}'>
		<div id="survey">
			<h3 id="surveyHeader">Survey Results</h3>
			<table class="surveyResults">
				<tr>
					<th>Park</th>
					<th>Number of Votes</th>
				</tr>
			<c:forEach var="surveyResponse" items="${surveyResponses}">
				<tr>
					<td class="parkResponses">${surveyResponse.key}</td>
					<td class="votes">${surveyResponse.value}</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</c:when>
	
	<c:otherwise>
		<form action="survey" method="POST" class="survey">
			<label for="answer" id="surveyFormHeader">Choose your favorite national park!</label><br>
				<div class="surveyOptions">
					<c:forEach var="park" items="${parks}">
						<input type="radio" name="answer" value="${park.parkName}" /> ${park.parkName}<br>
					</c:forEach>
				</div>
				<input type="hidden" name="completedSurvey" value="true">	
				<input type="submit" value="Submit" id="submit">
		</form>
	</c:otherwise>
</c:choose>

<c:import url ="/WEB-INF/jsp/footer.jsp" />