<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="layout/header.jsp"/>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

    body{
        background:#f4f8fb;
    }

    /* chiếm toàn bộ chiều cao còn lại */
    .page-wrapper{
        min-height: calc(100vh - 120px);
        display:flex;
        align-items:center;
        justify-content:center;
    }

    /* card */
    .register-card{
        width:650px;
        border-radius:10px;
        box-shadow:0 3px 12px rgba(0,0,0,0.1);
    }

    /* header card */
    .register-header{
        background:#0d6efd;
        color:white;
        text-align:center;
        padding:8px;
        font-size:18px;
        border-radius:10px 10px 0 0;
    }

    /* giảm khoảng cách form */
    .form-control{
        padding:6px 8px;
        font-size:14px;
    }

    .form-label{
        font-size:13px;
        margin-bottom:2px;
    }

    .mb-small{
        margin-bottom:8px;
    }

</style>


<div class="container-fluid page-wrapper">

    <div class="card register-card">

        <div class="register-header">
            Create Account
        </div>

        <div class="card-body p-3">

            <c:if test="${not empty error}">
                <div class="alert alert-danger py-1">
                    ${error}
                </div>
            </c:if>

            <form action="${pageContext.request.contextPath}/register" method="post">

                <div class="row">

                    <div class="col-md-6 mb-small">
                        <label class="form-label">Username</label>
                        <input type="text" name="username" class="form-control">
                    </div>

                    <div class="col-md-6 mb-small">
                        <label class="form-label">Password</label>
                        <input type="password" name="password" class="form-control">
                    </div>

                    <div class="col-md-6 mb-small">
                        <label class="form-label">Full Name</label>
                        <input type="text" name="fullname" class="form-control">
                    </div>

                    <div class="col-md-6 mb-small">
                        <label class="form-label">Phone</label>
                        <input type="text" name="phone" class="form-control">
                    </div>

                    <div class="col-md-6 mb-small">
                        <label class="form-label">CCCD</label>
                        <input type="text" name="cccd" class="form-control">
                    </div>

                    <div class="col-md-6 mb-small">
                        <label class="form-label">Email</label>
                        <input type="text" name="email" class="form-control">
                    </div>

                </div>

                <button class="btn btn-primary w-100 mt-2">
                    Create Account
                </button>

            </form>
            <div class="text-center mt-2">
                Already have an account?
                <a href="${pageContext.request.contextPath}/login" class="text-primary fw-semibold">
                    Login
                </a>
            </div>
        </div>

    </div>

</div>

<jsp:include page="layout/footer.jsp"/>