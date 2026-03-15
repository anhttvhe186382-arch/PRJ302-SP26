<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container">

<h2>Booking</h2>

<form action="${pageContext.request.contextPath}/booking" method="post">

<input type="hidden" name="motorbikeId" value="${param.motorbikeId}">

Daily Price
<input type="text" value="${param.dailyPrice}" readonly>

Rental Days
<input type="number" name="rentalDays">

<button>Confirm Booking</button>

</form>

</div>

<jsp:include page="layout/footer.jsp"/>
