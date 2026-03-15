<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container">

<h2>Motorbike List</h2>

<table border="1" width="100%">

<tr>
<th>ID</th>
<th>Model</th>
<th>Brand</th>
<th>Price</th>
<th>Action</th>
</tr>

<c:forEach var="m" items="${motorbikes}">

<tr>

<td>${m.id}</td>
<td>${m.modelName}</td>
<td>${m.brand}</td>
<td>$${m.dailyPrice}</td>
<td>
<img src="${pageContext.request.contextPath}/static/img/bike.png" width="120">
</td>

<td>

<a href="motorbike-detail.jsp?id=${m.id}">
View
</a>

</td>

</tr>

</c:forEach>

</table>

</div>

<jsp:include page="layout/footer.jsp"/>
