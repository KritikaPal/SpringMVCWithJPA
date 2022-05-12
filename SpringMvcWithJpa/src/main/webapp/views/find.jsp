<html>
<body>
<h1>Find Screen</h1>
<table border="1" width="90%">
<tr>
<th>Emp No</th><th>Emp Name</th><th>Emp Salary</th>
</tr>
<tr>
<td>${msg1}</td><td>${msg2}</td><td>${msg3}</td>
</tr>
</table><br><br><br>
<a href="/">Home</a><br><br>
<form action ="findRecord" method="post">
<input type="text" name="empNo" placeholder="Enter the number"><br><br>
<input type="submit" value="Find Record">
</form>
</body>
</html>