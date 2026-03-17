<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="layout/header.jsp"/>

<!-- Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

    body{
        background: linear-gradient(120deg,#f6fbff,#eaf4ff);
    }

    .login-card{
        max-width:420px;
        margin:auto;
        margin-top:80px;
        padding:35px;
        border-radius:15px;
        background:white;
        box-shadow:0 8px 25px rgba(0,0,0,0.1);
    }

    .login-title{
        text-align:center;
        margin-bottom:25px;
        color:#0d6efd;
        font-weight:600;
    }

    .form-control{
        border-radius:8px;
    }

    .btn-login{
        width:100%;
        border-radius:8px;
    }

    .register-link{
        text-align:center;
        margin-top:15px;
    }

</style>


<div class="container">

    <div class="login-card">

        <h2 class="login-title">Login</h2>

        <form action="${pageContext.request.contextPath}/login" method="post">

            <div class="mb-3">

                <label class="form-label">Username</label>

                <input 
                    type="text" 
                    name="username"
                    class="form-control"
                    placeholder="Enter your username">

            </div>

            <div class="mb-3">

                <label class="form-label">Password</label>

                <input 
                    type="password" 
                    name="password"
                    class="form-control"
                    placeholder="Enter your password">

            </div>

            <br>

            <button class="btn btn-primary btn-login">
                Login
            </button>

        </form>

        <div class="register-link">

            <a href="${pageContext.request.contextPath}/register" 
               class="text-decoration-none">
                Register
            </a>

        </div>

    </div>

</div>


<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script>

    document.querySelector("form").addEventListener("submit", function (e) {

        let user = document.querySelector("input[name='username']").value;
        let pass = document.querySelector("input[name='password']").value;

        if (user.trim() === "" || pass.trim() === "") {
            alert("Please enter username and password");
            e.preventDefault();
        }

    });

</script>


<jsp:include page="layout/footer.jsp"/>