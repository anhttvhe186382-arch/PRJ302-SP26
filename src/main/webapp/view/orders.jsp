<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container">

<h2>My Orders</h2>

<table border="1" width="100%">

<tr>
<th>ID</th>
<th>Motorbike</th>
<th>Total</th>
<th>Status</th>
<th>Detail</th>
</tr>

<c:forEach var="o" items="${orders}">

<tr>

<td>${o.id}</td>
<td>${o.motorbikeId}</td>
<td>$${o.totalPrice}</td>
<td>${o.status}</td>

<td>
<a href="order-detail.jsp?id=${o.id}">
View
</a>
</td>

</tr>

</c:forEach>

</table>

</div>

<jsp:include page="layout/footer.jsp"/>