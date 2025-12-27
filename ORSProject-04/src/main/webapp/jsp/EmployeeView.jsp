<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.controller.EmployeeCtl"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.bean.DepartmentBean"%>

<html>
<head>
<title>Add Employee</title>
<link rel="icon" type="image/png"
	href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>

<body>
	<form action="<%=ORSView.EMPLOYEE_CTL%>" method="post">

		<%@ include file="Header.jsp"%>

		<jsp:useBean id="bean"
			class="in.co.rays.proj4.bean.EmployeeBean" scope="request"></jsp:useBean>

		<%
			// Dynamic preload for departments
			List<DepartmentBean> deptList = (List<DepartmentBean>) request.getAttribute("departmentList");
		%>

		<div align="center">
			<h1 align="center" style="margin-bottom: -15; color: navy">
				<%
					if (bean != null && bean.getId() > 0) {
				%>Update<%
					} else {
				%>Add<%
					}
				%>
				Employee
			</h1>

			<div style="height: 15px; margin-bottom: 12px">
				<h3 align="center">
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
				</h3>
				<h3 align="center">
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>
			</div>

			<input type="hidden" name="id" value="<%=bean.getId()%>">
			<input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>">
			<input type="hidden" name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

			<table>
				<tr>
					<th align="left">Name<span style="color: red">*</span></th>
					<td><input type="text" name="name"
						placeholder="Enter Name"
						value="<%=DataUtility.getStringData(bean.getName())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Email<span style="color: red">*</span></th>
					<td><input type="text" name="email"
						placeholder="Enter Email"
						value="<%=DataUtility.getStringData(bean.getEmail())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("email", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Phone<span style="color: red">*</span></th>
					<td><input type="text" name="phone"
						placeholder="Enter Phone"
						value="<%=DataUtility.getStringData(bean.getPhone())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("phone", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Salary<span style="color: red">*</span></th>
					<td><input type="text" name="salary"
						placeholder="Enter Salary"
						value="<%=DataUtility.getStringData(bean.getSalary())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("salary", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Gender<span style="color: red">*</span></th>
					<td>
						<%
							HashMap<String, String> genderMap = new HashMap<String, String>();
							genderMap.put("Male", "Male");
							genderMap.put("Female", "Female");
							String genderList = HTMLUtility.getList("gender", bean.getGender(), genderMap);
						%>
						<%=genderList%>
					</td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("gender", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Department<span style="color: red">*</span></th>
					<td>
						<%=HTMLUtility.getList("department", bean.getDepartment(), deptList)%>
					</td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("departmentId", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Join Date<span style="color: red">*</span></th>
					<td><input type="text" name="joinDate" id="udate" placeholder="E+nter Joining Date"
						value="<%=DataUtility.getDateString(bean.getJoinDate())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("joinDate", request)%></font></td>
				</tr>

				<tr>
					<th></th>
					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<td colspan="2">
						<input type="submit" name="operation" value="<%=EmployeeCtl.OP_UPDATE%>">
						<input type="submit" name="operation" value="<%=EmployeeCtl.OP_CANCEL%>">
					</td>
					<%
						} else {
					%>
					<td colspan="2">
						<input type="submit" name="operation" value="<%=EmployeeCtl.OP_SAVE%>">
						<input type="submit" name="operation" value="<%=EmployeeCtl.OP_RESET%>">
					</td>
					<%
						}
					%>
				</tr>
			</table>
		</div>
	</form>

	<%@ include file="Footer.jsp"%>
</body>
</html>
