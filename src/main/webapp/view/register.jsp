<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>
<div class="container">

<h2>Register</h2>

<form action="${pageContext.request.contextPath}/register" method="post">

Username
<input type="text" name="username">

Password
<input type="password" name="password">

Full Name
<input type="text" name="fullname">

Phone
<input type="text" name="phone">

Email
<input type="text" name="email">

<br><br>

<button>Create Account</button>

</form>

</div>

<jsp:include page="layout/footer.jsp"/>
