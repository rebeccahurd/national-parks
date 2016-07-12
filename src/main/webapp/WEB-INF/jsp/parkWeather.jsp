<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<c:import url="/WEB-INF/jsp/header.jsp">
</c:import>

	<h3>5-Day Weather Forecast: ${park.parkName}</h3>
	<c:choose>
		<c:when test='${tempIsCelsius}'>
			<c:url var="fahrenheitHref" value="/parkWeather">
				<c:param name="tempIsCelsius">false</c:param>
				<c:param name="parkCode">${park.parkCode}</c:param>
			</c:url>
			<a href="${fahrenheitHref}" class="tempToggle">Toggle &#8451/&#8457</a>
		</c:when>	
		
		<c:otherwise>
			<c:url var="fahrenheitHref" value="/parkWeather">
				<c:param name="tempIsCelsius">true</c:param>
				<c:param name="parkCode">${park.parkCode}</c:param>
			</c:url>
			<a href="${fahrenheitHref}" class="tempToggle">Toggle &#8451/&#8457</a>
		</c:otherwise>
	</c:choose>
	<div id="weatherForecastContainer">
		<c:forEach var="forecast" items="${weatherForecasts}">
			<div id="weatherForecast">
				<h3>${forecast.dayOfWeek}</h3>
				<c:url var="weatherImgSrc" value="img/weather/${forecast.forecastDescription}.png" />
				<img src="${weatherImgSrc}" />
				<p>Weather Tips: ${forecast.weatherTips}</p>	
				<c:choose>	
					<c:when test="${tempIsCelsius}">
						<p>High: ${forecast.forecastHighInCelsius}&#8451 </p>
						<p>Low: ${forecast.forecastLowInCelsius}&#8451</p>	
					</c:when>
					<c:otherwise>
						<p>High: ${forecast.forecastHighInFahrenheit}&#8457</p>
						<p>Low: ${forecast.forecastLowInFahrenheit}&#8457</p>
					</c:otherwise>
				</c:choose>		
				<p>Forecast: ${forecast.forecastDescription}</p>
			</div>
		</c:forEach>
	</div>

<c:import url ="/WEB-INF/jsp/footer.jsp" />