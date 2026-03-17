<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <img src="${pageContext.request.contextPath}/${bike.model.imagePath}" 
                 class="img-fluid rounded shadow" alt="${bike.model.modelName}">
        </div>

        <div class="col-md-6">
            <h2 class="fw-bold">${bike.model.brand} ${bike.model.modelName}</h2>
            <hr>
            <p class="text-muted italic">${bike.model.description}</p>
            
            <div class="bg-light p-3 rounded">
                <p><b>Biển số xe:</b> <span class="text-primary">${bike.licensePlate}</span></p>
                <p><b>Giá thuê theo ngày:</b> 
                    <span class="text-success fs-4 fw-bold">${bike.dailyPrice} VND</span>
                </p>
                <p><b>Tiền đặt cọc:</b> 
                    <span class="text-danger fw-bold">${bike.depositPrice} VND</span>
                </p>
            </div>

            <form action="booking" method="POST" class="mt-4">
                <input type="hidden" name="bikeId" value="${bike.id}">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Ngày nhận xe</label>
                        <input type="date" name="startDate" class="form-control" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Ngày trả xe</label>
                        <input type="date" name="endDate" class="form-control" required>
                    </div>
                </div>
                <button type="submit" class="btn btn-warning btn-lg w-100 fw-bold">XÁC NHẬN ĐẶT XE</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="layout/footer.jsp"/>