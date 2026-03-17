<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">

    <div class="container">

        <!-- Logo -->
        <a class="navbar-brand fw-bold"
           href="${pageContext.request.contextPath}/viewMotorbike">
            Motorbike Rental
        </a>

        <!-- Mobile toggle -->
        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarMenu">

            <span class="navbar-toggler-icon"></span>

        </button>

        <!-- Menu -->
        <div class="collapse navbar-collapse" id="navbarMenu">

            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/viewMotorbike">
                        Motorbikes
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/orders">
                        My Orders
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/profile">
                        Profile
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-danger fw-semibold"
                       href="${pageContext.request.contextPath}/logout">
                        Logout
                    </a>
                </li>

            </ul>

        </div>

    </div>

</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>