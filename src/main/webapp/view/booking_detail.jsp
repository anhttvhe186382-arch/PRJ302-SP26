<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<style>
    :root {
        --bike-blue: #0d6efd;
        --bike-light-blue: #e7f1ff;
    }
    .booking-card {
        border-radius: 20px;
        overflow: hidden;
        border: none;
    }
    .bg-gradient-blue {
        background: linear-gradient(135deg, #0d6efd 0%, #0a58ca 100%);
    }
    .qr-container {
        background-color: var(--bike-light-blue);
        border: 2px dashed #0d6efd;
        border-radius: 15px;
    }
    .info-label {
        color: #6c757d;
        font-size: 0.9rem;
    }
    .info-value {
        font-weight: 600;
        color: #212529;
    }
    .price-total {
        font-size: 1.5rem;
        color: #0d6efd;
    }
</style>

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-10">
            <div class="card booking-card shadow-lg">
                <div class="card-header bg-gradient-blue text-white py-4 text-center">
                    <h3 class="mb-0 fw-bold"><i class="bi bi-check2-circle"></i> XÁC NHẬN ĐẶT XE</h3>
                    <p class="mb-0 opacity-75">Vui lòng kiểm tra thông tin và thanh toán cọc</p>
                </div>

                <div class="card-body p-4 p-md-5">
                    <div class="row g-4">
                        <div class="col-md-7">
                            <div class="d-flex align-items-center mb-4">
                                <div class="bg-primary text-white rounded-circle d-flex align-items-center justify-content-center me-3" style="width: 50px; height: 50px;">
                                    <i class="bi bi-bicycle fs-4"></i>
                                </div>
                                <div>
                                    <h4 class="mb-0 fw-bold text-dark">${bike.model.brand} ${bike.model.modelName}</h4>
                                    <span class="badge bg-info text-dark">Biển số: ${bike.licensePlate}</span>
                                </div>
                            </div>

                            <div class="row g-3">
                                <div class="col-6">
                                    <p class="info-label mb-1">Thời gian thuê</p>
                                    <p class="info-value">${rentalDays} ngày</p>
                                </div>
                                <div class="col-6">
                                    <p class="info-label mb-1">Trạng thái xe</p>
                                    <p class="info-value text-primary">Đã giữ chỗ (Reserved)</p>
                                </div>
                                <div class="col-12"><hr class="my-2 opacity-10"></div>
                                <div class="col-6">
                                    <p class="info-label mb-1">Đơn giá</p>
                                    <p class="info-value">${bike.dailyPrice} VND/ngày</p>
                                </div>
                                <div class="col-6">
                                    <p class="info-label mb-1">Tiền cọc (Hoàn lại)</p>
                                    <p class="info-value text-danger">${bike.depositPrice} VND</p>
                                </div>
                            </div>

                            <div class="mt-4 p-3 rounded-3 bg-light border-start border-primary border-4">
                                <div class="d-flex justify-content-between align-items-center">
                                    <span class="h5 mb-0 fw-bold">Tổng tiền thuê:</span>
                                    <span class="price-total fw-bold">${totalPrice} VND</span>
                                </div>
                            </div>

                            <div class="alert alert-info mt-4 border-0">
                                <small><i class="bi bi-info-circle-fill me-2"></i>Hệ thống đã tự động chuyển trạng thái xe sang <b>Reserved</b>. Vui lòng thanh toán trong vòng 15 phút để đảm bảo đơn đặt.</small>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="qr-container p-4 text-center h-100 d-flex flex-column justify-content-center">
                                <h5 class="fw-bold mb-3 text-primary">Thanh toán chuyển khoản</h5>

                                <div class="bg-white p-2 d-inline-block rounded shadow-sm mb-3">
                                    <img src="${pageContext.request.contextPath}/static/img/airblade.jpg" 
                                         alt="QR Payment" class="img-fluid" style="max-width: 200px;">
                                </div>

                                <div class="payment-details text-start mx-auto" style="max-width: 200px;">
                                    <p class="small mb-1 text-muted">Chủ tài khoản:</p>
                                    <p class="fw-bold mb-2">NGUYEN VAN A</p>
                                    <p class="small mb-1 text-muted">Nội dung chuyển khoản:</p>
                                    <p class="text-primary fw-bold mb-0">CK COC ${bike.licensePlate}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card-footer bg-white p-4 border-top-0 d-flex flex-column flex-md-row justify-content-center gap-3">

                    <a href="${pageContext.request.contextPath}/viewMotorbike" 
                       class="btn btn-primary btn-lg px-5 shadow-sm fw-bold">
                        <i class="bi bi-check-lg me-2"></i>Xác nhận đã chuyển khoản
                    </a>

                    <a href="${pageContext.request.contextPath}/viewMotorbike" 
                       class="btn btn-outline-secondary btn-lg px-4 fw-bold">
                        Quay lại trang chủ
                    </a>

                </div>
            </div>

            <p class="text-center mt-4 text-muted small">
                &copy; 2026 PRJ302 Motorbike Rental - Dịch vụ cho thuê xe máy uy tín hàng đầu.
            </p>
        </div>
    </div>
</div>
<jsp:include page="layout/footer.jsp"/>