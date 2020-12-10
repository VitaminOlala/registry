<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý thông tin người dùng</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>Quản lý thông tin người dùng</h1>
	</div>
	<s:form action="timKiemNguoiDung" method="POST" theme="simple">
		<fieldset>
		<legend>Nhập thông tin người dùng</legend>
		<table>
			<tr>
				<td>
				Từ khoá:
				</td>
				<td>
					<s:textfield name="tuKhoa" value="%{tuKhoa}"/>
				</td>
				<td>				
				<td>

				<td>
					<s:submit value="Tìm kiếm"/>
				</td>
			</tr>
		</table>
		</fieldset>
	</s:form>

	<table style="width:100%;" border="1">
		<tr>
			<th>Id</th>
			<th>Tên đăng nhập</th>
			<th>Mật khẩu</th>
			<th>Họ tên</th>
			<th>Điện thoại</th>
			<th>Email</th>
			<th>Địa chỉ</th>
		</tr>
		<s:iterator value="lstNguoiDung" var="b">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="tenDangNhap" /></td>
				
				<td><s:property value="matKhau" /></td>
				<td><s:property value="hoTen" /></td>
				<td><s:property value="dienThoai"/>
				</td>
				<td><s:property value="email"/></td>
				<td><s:property value="diaChi"/></td>
				<td><a href='<s:url action="chiTietNguoiDung?ma=%{id}"/>'>Sửa</a>
					&nbsp; <a href='<s:url action="xoaNguoiDung?ma=%{id}"/>'
					onclick="return confirm('Bạn có chắc chắn muốn xoá thông tin này ?');">Xoá</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>