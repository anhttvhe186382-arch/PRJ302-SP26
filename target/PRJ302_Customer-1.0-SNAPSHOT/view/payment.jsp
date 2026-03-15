<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container">

<h2>Deposit Payment</h2>

<form action="${pageContext.request.contextPath}/payment" method="post">

Booking ID
<input type="text" name="bookingId">

Amount
<input type="text" name="amount">

<select name="method">
<option>Cash</option>
<option>Transfer</option>
</select>

<button>Pay</button>

</form>

</div>

<jsp:include page="layout/footer.jsp"/>