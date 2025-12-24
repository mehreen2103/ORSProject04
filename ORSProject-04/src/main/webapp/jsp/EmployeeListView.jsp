<%@page import="in.co.rays.proj4.bean.EmployeeBean"%>
<%@page import="in.co.rays.proj4.bean.RoleBean"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="in.co.rays.proj4.model.RoleModel"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.BaseBean"%>
<%@page import="in.co.rays.proj4.controller.EmployeeListCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<html>
<head>
    <title>Employee List</title>
    <link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
    <%@include file="Header.jsp"%>

    <jsp:useBean id="bean" class="in.co.rays.proj4.bean.EmployeeBean" scope="request"></jsp:useBean>

    <div align="center">
        <h1 align="center" style="margin-bottom: -15; color: navy;">Employee List</h1>

        <div style="height: 15px; margin-bottom: 12px">
            <h3><font color="red"><%=ServletUtility.getErrorMessage(request)%></font></h3>
            <h3><font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></h3>
        </div>

        <!-- Fixed form action -->
        <form action="<%=ORSView.EMPLOYEE_LIST_CTL%>" method="post">
            <%
                int pageNo = ServletUtility.getPageNo(request);
                int pageSize = ServletUtility.getPageSize(request);
                int index = ((pageNo - 1) * pageSize) + 1;
                int nextListSize = 0;
                if(request.getAttribute("nextListSize") != null) {
                    nextListSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());
                }
            %>

            <input type="hidden" name="pageNo" value="<%=pageNo%>">
            <input type="hidden" name="pageSize" value="<%=pageSize%>">

            <table style="width: 100%">
                <tr>
                    <td align="center">
                        <label><b>Name :</b></label>
                        <input type="text" name="firstName" placeholder="Enter First Name" value="<%=ServletUtility.getParameter("firstName", request)%>">&emsp;

                        <label><b>Email:</b></label>
                        <input type="text" name="login" placeholder="Enter Email ID" value="<%=ServletUtility.getParameter("login", request)%>">&emsp;

                        <input type="submit" name="operation" value="<%=EmployeeListCtl.OP_SEARCH%>">
                        &nbsp;
                        <input type="submit" name="operation" value="<%=EmployeeListCtl.OP_RESET%>">
                    </td>
                </tr>
            </table>
            <br>

            <table border="1" style="width: 100%; border: groove;">
                <tr style="background-color: #e1e6f1e3;">
                    <th width="5%"><input type="checkbox" id="selectall" /></th>
                    <th width="5%">Sr.No</th>
                    <th width="13%">Name</th>
                    <th width="23%">Email</th>
                    <th width="10%">Phone</th>
                    <th width="8%">Salary</th>
                    <th width="10%">Department</th>
                    <th width="8%">Join Date</th>
                    <th width="5%">Edit</th>
                </tr>

                <%
                    List<EmployeeBean> list = (List<EmployeeBean>)request.getAttribute("list");
                    if(list != null && !list.isEmpty()) {
                        for(EmployeeBean emp : list) {
                %>
                <tr>
                    <td style="text-align: center;">
                        <input type="checkbox" name="ids" value="<%=emp.getId()%>">
                    </td>
                    <td style="text-align: center;"><%=index++%></td>
                    <td style="text-align: center; text-transform: capitalize;"><%=emp.getName()%></td>
                    <td style="text-align: center; text-transform: lowercase;"><%=emp.getEmail()%></td>
                    <td style="text-align: center;"><%=emp.getPhone()%></td>
                    <td style="text-align: center;"><%=emp.getSalary()%></td>
                    <td style="text-align: center;"><%=emp.getDepartment()%></td>
                    <td style="text-align: center;"><%=emp.getJoinDate()%></td>
                    <!-- Fixed Edit link -->
                    <td style="text-align: center;">
                        <a href="<%=ORSView.EMPLOYEE_CTL%>?id=<%=emp.getId()%>">Edit</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>

            <table style="width: 100%">
                <tr>
                    <td style="width: 25%">
                        <input type="submit" name="operation" value="<%=EmployeeListCtl.OP_PREVIOUS%>" <%=pageNo > 1 ? "" : "disabled"%>>
                    </td>
                    <td align="center" style="width: 25%">
                        <input type="submit" name="operation" value="<%=EmployeeListCtl.OP_NEW%>">
                    </td>
                    <td align="center" style="width: 25%">
                        <input type="submit" name="operation" value="<%=EmployeeListCtl.OP_DELETE%>">
                    </td>
                    <td style="width: 25%" align="right">
                        <input type="submit" name="operation" value="<%=EmployeeListCtl.OP_NEXT%>" <%=nextListSize != 0 ? "" : "disabled"%>>
                    </td>
                </tr>
            </table>

<!--             <table> -->
<!--                 <tr> -->
<!--                     <td align="right"> -->
<%--                         <input type="submit" name="operation" value="<%=EmployeeListCtl.OP_BACK%>"> --%>
<!--                     </td> -->
<!--                 </tr> -->
<!--             </table> -->
        </form>
    </div>
    <%@ include file="Footer.jsp"%>
</body>
</html>
