<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container">

<h2>Motorbike Detail</h2>

<p>Model: ${motorbike.modelName}</p>
<p>Brand: ${motorbike.brand}</p>
<p>Daily Price: $${motorbike.dailyPrice}</p>
<p>Deposit: $${motorbike.depositPrice}</p>

<form action="booking.jsp">

<input type="hidden" name="motorbikeId" value="${motorbike.id}">
<input type="hidden" name="dailyPrice" value="${motorbike.dailyPrice}">
<input type="hidden" name="depositPrice" value="${motorbike.depositPrice}">

<button>Book Now</button>

</form>

</div>

<jsp:include page="layout/footer.jsp"/>
