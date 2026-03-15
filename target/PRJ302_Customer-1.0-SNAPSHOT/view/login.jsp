<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container">

    <h2>Login</h2>

    <form action="${pageContext.request.contextPath}/login" method="post">

        Username
        <input type="text" name="username">

        Password
        <input type="password" name="password">

        <br><br>

        <button>Login</button>

        </foFrm>

        <br>

        <a href="register.jsp">Register</a>

</div>

<jsp:include page="layout/footer.jsp"/>
