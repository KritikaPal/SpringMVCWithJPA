<%@page import="java.util.Iterator"%>
<%@page import="com.kritika.demo.model.Emp"%>
<%@page import="java.util.List"%>
<html>
<body>
<table border="1" width="90%">
<tr>
<th>Emp No</th><th>Emp Name</th><th>Emp Salary</th><th>Edit</th><th>Delete</th>
</tr>
<% 
List<Emp>l=(List)request.getAttribute("records");
Iterator<Emp>itr = l.iterator();
while(itr.hasNext())
{
	Emp e = itr.next();
	%>
	<tr>
	<td><%=e.getEmpNo() %></td>
	<td><%=e.getEmpName() %></td>
	<td><%=e.getEmpSal() %></td>
	<td><a href="update">Update</a></td>
	<td><a href="/deleteRecord/<%=e.getEmpNo()%>">Delete</a></td>
	<% 
}
	%>
	</tr>
</table>
<a href="/">Home</a><br><br>
<a href="/find">Find</a><br><br><br>
<a href="/add">Add Record</a><br><br>
</body>
</html>