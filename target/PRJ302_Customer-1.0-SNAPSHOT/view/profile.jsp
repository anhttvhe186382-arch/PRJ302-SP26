<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container">

<h2>My Profile</h2>

<form action="${pageContext.request.contextPath}/profile" method="post">

Username
<input type="text" value="${sessionScope.account.username}" readonly>

Full Name
<input type="text" name="fullname" value="${sessionScope.account.fullname}">

Phone
<input type="text" name="phone" value="${sessionScope.account.phone}">

Email
<input type="text" name="email" value="${sessionScope.account.email}">

<button>Update</button>

</form>

</div>

<jsp:include page="layout/footer.jsp"/>
