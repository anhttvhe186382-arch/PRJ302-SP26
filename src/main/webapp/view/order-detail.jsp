<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container">

<h2>Order Detail</h2>

<p>Booking ID: ${order.id}</p>
<p>Motorbike ID: ${order.motorbikeId}</p>
<p>Total Price: $${order.totalPrice}</p>
<p>Status: ${order.status}</p>

</div>

<jsp:include page="layout/footer.jsp"/>
