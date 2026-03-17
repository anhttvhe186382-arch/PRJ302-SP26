<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbar.jsp"/>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

.profile-wrapper{
    margin-top:40px;
    margin-bottom:40px;
}

.profile-card{
    border:none;
    border-radius:14px;
    box-shadow:0 6px 18px rgba(0,0,0,0.08);
}

.profile-header{
    background:#0d6efd;
    color:white;
    padding:25px;
    border-radius:14px 14px 0 0;
}

.profile-avatar{
    width:90px;
    height:90px;
    border-radius:50%;
    background:white;
    color:#0d6efd;
    display:flex;
    align-items:center;
    justify-content:center;
    font-size:32px;
    font-weight:bold;
    margin-bottom:10px;
}

.profile-info p{
    margin-bottom:12px;
    font-size:15px;
}

.info-label{
    font-weight:600;
    color:#555;
    width:140px;
    display:inline-block;
}

</style>

<div class="container profile-wrapper">

```
<div class="row justify-content-center">

    <div class="col-md-6">

        <div class="card profile-card">

            <!-- HEADER -->
            <div class="profile-header text-center">

                <div class="profile-avatar mx-auto">
                    ${account.username.substring(0,1).toUpperCase()}
                </div>

                <h4 class="mb-1">${account.fullname}</h4>
                <small>${account.role}</small>

            </div>

            <!-- BODY -->
            <div class="card-body profile-info">

                <h5 class="mb-4">Account Information</h5>

                <p>
                    <span class="info-label">Username:</span>
                    ${account.username}
                </p>

                <p>
                    <span class="info-label">Full Name:</span>
                    ${account.fullname}
                </p>

                <p>
                    <span class="info-label">Phone:</span>
                    ${account.phone}
                </p>

                <p>
                    <span class="info-label">Gender:</span>
                    ${account.gender}
                </p>

                <p>
                    <span class="info-label">CCCD:</span>
                    ${account.idCardNo}
                </p>

                <p>
                    <span class="info-label">Role:</span>
                    <span class="badge bg-primary">
                        ${account.role}
                    </span>
                </p>

            </div>

        </div>

    </div>

</div>
```

</div>

<jsp:include page="layout/footer.jsp"/>
