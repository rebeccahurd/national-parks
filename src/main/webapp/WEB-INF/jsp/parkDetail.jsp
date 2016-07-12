<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<c:import url="/WEB-INF/jsp/header.jsp">
    <c:param name="pageTitle" value="${park.parkName}" />
</c:import>

	<div id="parkDetails">
		<h4>Location: ${park.state}</h4>
		<p>Entry Fee: ${park.entryFee}</p>
		<p id="quote">${park.quote} - ${park.quoteSource}</p>
		
		<c:url var="parkImgSrc" value="/img/parks/${park.parkCode}.jpg" />
		<img src="${parkImgSrc}" />
		
		<div class="parkDescription">
			<h4>Key Facts</h4>
			<table class="parkFacts">
				<tr>
					<td>Acreage:</td>
					<td>${park.acreage} acres</td>
				</tr>
				<tr>
					<td>Elevation:</td>
					<td>${park.elevationInFeet} feet</td>
				</tr>
				<tr>
					<td>Miles of Trail:</td>
					<td>${park.milesOfTrail}</td>
				</tr>
				<tr>
					<td>Number of Campsites:</td>
					<td>${park.numberOfCampsites}</td>
				</tr>
				<tr>
					<td>Climate:</td>
					<td>${park.climate}</td>
				</tr>
				<tr>
					<td>Year Founded:</td>
					<td>${park.yearFounded}</td>
				</tr>
				<tr>
					<td>Annual Visitor Count:</td>
					<td>${park.annualVisitorCount} visitors</td>
				</tr>
				<tr>
					<td>Number of Animal Species:</td>
					<td>${park.numberOfAnimalSpecies}</td>
				</tr>
			</table>
		
			<p>${park.description}</p>
		</div>
	</div>	
	
	<div class="weatherSummary">
		<h2>Today's Weather</h2>
		
		<c:choose>
			<c:when test='${tempIsCelsius == "true"}'>
				<c:url var="fahrenheitHref" value="/parkDetail">
					<c:param name="tempIsCelsius">false</c:param>
					<c:param name="parkCode">${park.parkCode}</c:param>
				</c:url>
				<a href="${fahrenheitHref}" class="tempToggle">Toggle &#8451/&#8457</a>
			</c:when>	
			
			<c:otherwise>
				<c:url var="fahrenheitHref" value="/parkDetail">
					<c:param name="tempIsCelsius">true</c:param>
					<c:param name="parkCode">${park.parkCode}</c:param>
				</c:url>
				<a href="${fahrenheitHref}" class="tempToggle">Toggle &#8451/&#8457</a>
			</c:otherwise>
		</c:choose>
		
		<c:url var="parkHref" value="/parkWeather">
			<c:param name="parkCode">${park.parkCode}</c:param>
		</c:url>
		
		<h3><a href="${parkHref}">See 5-Day Forecast</a></h3>
		<c:url var="weatherImgSrc" value="img/weather/${parkWeather.forecastDescription}.png" />
		<img src="${weatherImgSrc}" />
		
		<c:choose>	
			<c:when test="${tempIsCelsius}">
				<p>High: ${parkWeather.forecastHighInCelsius}&#8451 </p>
				<p>Low: ${parkWeather.forecastLowInCelsius}&#8451</p>	
			</c:when>
			<c:otherwise>
				<p>High: ${parkWeather.forecastHighInFahrenheit}&#8457</p>
				<p>Low: ${parkWeather.forecastLowInFahrenheit}&#8457</p>
			</c:otherwise>
		</c:choose>
			
		<p>Forecast: ${parkWeather.forecastDescription}</p>
		
	</div>
	
<c:import url ="/WEB-INF/jsp/footer.jsp" />
