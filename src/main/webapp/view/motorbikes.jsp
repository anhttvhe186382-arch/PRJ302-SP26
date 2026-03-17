<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    .filter-sidebar {
        background: white;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.08);
        position: sticky;
        top: 20px;
    }

    .filter-sidebar h5 {
        font-weight: 600;
    }

    .motorbike-card .card {
        transition: all 0.3s ease;
        border: none;
        border-radius: 12px;
        overflow: hidden;
    }

    .motorbike-card .card:hover {
        transform: translateY(-8px);
        box-shadow: 0 10px 20px rgba(0,0,0,0.12) !important;
    }

    .btn-booking {
        background-color: #0d6efd;
        border: none;
        font-weight: 600;
        transition: 0.2s;
    }

    .btn-booking:hover {
        background-color: #0b5ed7;
        letter-spacing: 0.5px;
    }

    .card-img-top {
        transition: transform 0.5s ease;
    }

    .motorbike-card:hover .card-img-top {
        transform: scale(1.05);
    }
</style>

<div class="container mt-4">
    <div class="row">
        <div class="col-md-3">
            <div class="filter-sidebar">
                <h5 class="mb-3"><i class="bi bi-filter"></i> Bộ lọc</h5>

                <div class="mb-4">
                    <p class="fw-bold mb-2">Hãng xe</p>
                    <div class="form-check">
                        <input class="form-check-input brandCheck" type="checkbox" value="Honda" id="honda">
                        <label class="form-check-label" for="honda">Honda</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input brandCheck" type="checkbox" value="Yamaha" id="yamaha">
                        <label class="form-check-label" for="yamaha">Yamaha</label>
                    </div>
                </div>

                <div>
                    <p class="fw-bold mb-2">Giá thuê / ngày</p>
                    <div class="form-check">
                        <input class="form-check-input priceCheck" type="checkbox" value="low" id="p1">
                        <label class="form-check-label" for="p1">Dưới 150k</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input priceCheck" type="checkbox" value="mid" id="p2">
                        <label class="form-check-label" for="p2">150k - 200k</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input priceCheck" type="checkbox" value="high" id="p3">
                        <label class="form-check-label" for="p3">Trên 200k</label>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-9">
            <div class="mb-4">
                <input type="text" id="searchBox" class="form-control form-control-lg shadow-sm" 
                       placeholder="Tìm kiếm hãng xe, tên xe hoặc biển số...">
            </div>

            <h2 class="mb-4 text-dark fw-bold">Danh sách xe máy</h2>
            
            <div class="row" id="motorbikeContainer">
                <c:forEach var="m" items="${motorbikeList}">
                    <div class="col-md-4 col-sm-6 mb-4 motorbike-card"
                         data-brand="${m.model.brand}"
                         data-price="${m.dailyPrice}"
                         data-search="${m.model.brand} ${m.model.modelName} ${m.licensePlate}">

                        <div class="card h-100 shadow-sm">
                            <div style="overflow: hidden;">
                                <img src="${pageContext.request.contextPath}/${m.model.imagePath}"
                                     class="card-img-top"
                                     style="height:200px; object-fit:cover;"
                                     alt="${m.model.modelName}">
                            </div>

                            <div class="card-body d-flex flex-column">
                                <h5 class="card-title fw-bold text-truncate">
                                    ${m.model.brand} ${m.model.modelName}
                                </h5>

                                <div class="mb-3 small">
                                    <div class="d-flex justify-content-between mb-1">
                                        <span class="text-muted">Giá thuê:</span>
                                        <span class="text-success fw-bold">${m.dailyPrice}đ</span>
                                    </div>
                                    <div class="d-flex justify-content-between mb-1">
                                        <span class="text-muted">Tiền cọc:</span>
                                        <span class="text-danger fw-bold">${m.depositPrice}đ</span>
                                    </div>
                                    <div class="d-flex justify-content-between mb-1">
                                        <span class="text-muted">Biển số:</span>
                                        <span class="fw-bold">${m.licensePlate}</span>
                                    </div>
                                </div>

                                <div class="mt-auto">
                                    <div class="d-flex align-items-center justify-content-between mb-3">
                                        <span class="small text-muted">Trạng thái:</span>
                                        <c:choose>
                                            <c:when test="${m.status == 'Available'}">
                                                <span class="badge bg-success">Sẵn sàng</span>
                                            </c:when>
                                            <c:when test="${m.status == 'Rented'}">
                                                <span class="badge bg-warning text-dark">Đang được thuê</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="badge bg-secondary">${m.status}</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>

                                    <c:if test="${m.status == 'Available'}">
                                        <a href="${pageContext.request.contextPath}/booking?motorbikeId=${m.id}" 
                                           class="btn btn-primary btn-booking w-100 py-2 shadow-sm">
                                            ĐẶT NGAY
                                        </a>
                                    </c:if>
                                    <c:if test="${m.status != 'Available'}">
                                        <button class="btn btn-outline-secondary w-100 py-2" disabled>
                                            TẠM HẾT
                                        </button>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<script>
    const searchBox = document.getElementById("searchBox");
    const brandChecks = document.querySelectorAll(".brandCheck");
    const priceChecks = document.querySelectorAll(".priceCheck");

    function getCheckedValues(list) {
        return Array.from(list).filter(c => c.checked).map(c => c.value);
    }

    function filterMotorbikes() {
        let keyword = searchBox.value.toLowerCase();
        let brands = getCheckedValues(brandChecks);
        let prices = getCheckedValues(priceChecks);
        let cards = document.querySelectorAll(".motorbike-card");

        cards.forEach(card => {
            let text = card.dataset.search.toLowerCase();
            let brand = card.dataset.brand;
            let price = parseFloat(card.dataset.price);
            let show = true;

            if (keyword && !text.includes(keyword)) show = false;
            if (brands.length > 0 && !brands.includes(brand)) show = false;

            if (prices.length > 0) {
                let priceMatch = false;
                prices.forEach(p => {
                    if (p === "low" && price < 150000) priceMatch = true;
                    if (p === "mid" && price >= 150000 && price <= 200000) priceMatch = true;
                    if (p === "high" && price > 200000) priceMatch = true;
                });
                if (!priceMatch) show = false;
            }
            card.style.display = show ? "block" : "none";
        });
    }

    searchBox.addEventListener("input", filterMotorbikes);
    brandChecks.forEach(c => c.addEventListener("change", filterMotorbikes));
    priceChecks.forEach(c => c.addEventListener("change", filterMotorbikes));
</script>

<jsp:include page="layout/footer.jsp"/>