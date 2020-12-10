<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng tags của struts -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Sign in</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport">
<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:700%7CNunito:300,600"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="assets/css/bootstrap.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet" href="assets/css/font-awesome.min.css"> 
<link rel="stylesheet" type="text/css" href="CssLogin/cssRegisted.css">
</head>
<body>
<spring:form action="dangKyNguoiDung.htm" modelAttribute="objNguoiDung"  method="POST" enctype="multipart/form-data" onsubmit="return validation()"
		 >
	<div class="row justify-content-center">
		<div class="col col-md-5 text-center">
		
				<h1>Login</h1>

				<div class="form-row py-1">
					<label>Tên đăng nhập</label> <spring:input type="text"  id="tenDangNhap"
						placeholder="Username" class="form-control" name="tenDangNhap" path="tenDangNhap" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                              this.value = 'Tên đăng nhập'; }"
						/>
				</div>
				<div class="form-row py-1">
					<label>Mật khẩu</label> <spring:input type="password" class="form-control"  id="matKhau"
						placeholder="Password" name="matKhau" path="matKhau"  onfocus="this.value = '';" onblur="if (this.value == '') {
                                                              this.value = 'Mật khẩu'; }"
						/>
				</div>
			
				<div class="form-row py-1">
					<label>Họ tên</label> <spring:input type="text" placeholder="Họ tên" class="form-control" path="hoTen"  id="hoTen"
						name="hoTen"   onfocus="this.value = '';" onblur="if (this.value == '') {
                                                              this.value = 'Họ tên'; }"/>
				</div>
				<div class="form-row py-1">
					<label>Email</label> <spring:input type="text" placeholder="Email" class="form-control" id="email" path="email"
						name="email"   onfocus="this.value = '';" onblur="if (this.value == '') {
                                                              this.value = 'Email'; }"/>
				</div>
				<div class="form-row py-1">
					<label>Địa chỉ</label> <spring:input type="text" placeholder="Địa chỉ" class="form-control"  id="diaChi" path="diaChi"
						name="diaChi"  onfocus="this.value = '';" onblur="if (this.value == '') {
                                                              this.value = 'Địa chỉ'; }"/>
				</div>
				<div class="form-row py-1">
					<button type="submit" name ="btnCapNhat" value="Creat
						your account" class="btn-btn-info btn-block">Create</button>
				</div>




		
		</div>
	</div>
	</spring:form>
	           <script>                 
                var elm = document.getElementById("result").innerHTML;
                if(elm.length>0){
                    if(elm == "Đăng kí thành công") alert("Đăng kí thành công");
                    else if(elm == "Đăng kí thất bại" ) alert("Đăng kí thất bại");
                    else alert(elm);
                }
            </script>
            <script>
                function repass(){
                        var gmail = prompt("Nhập gmail hoặc số điện thoại");
                        document.getElementById("gmail").value = gmail;
                        document.getElementById("form").submit();                    
                }
                function result(){
                        var result = document.getElementById("result2").innerHTML;
                        alert(result);
                }
            </script>
</body>
</html>