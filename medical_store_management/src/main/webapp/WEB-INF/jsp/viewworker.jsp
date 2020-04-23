    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<head>
<link href="<c:url value="/resources/css/navtable.css" />" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/resources/images/back2.jpg">
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
			<ul>
			  <li class="left"><a class="active" href="/dbms_project/welcome/">Home</a></li>
			  <li class="right"><a href="javascript:formSubmit()"> Logout</a></li>
			</ul>
	</c:if>
	<div class="loginBox">
	<h1>Worker List</h1>
	<table id="tab">
	<tr><th>Id</th><th>UserName</th><th>Name</th><th>Contact No.</th><th>Aadhar No.</th><th>House No.</th><th>Street</th><th>Area</th><th>Salary</th><th>Joining Date</th><th>Branch</th><th>Edit Medical Store</th><th>Edit Bank</th><th>Delete</th></tr>
    <c:forEach var="w" items="${list}"> 
    <tr>
    <td>${w.worker_ID}</td>
    <td>${w.username}</td>
    <td>${w.name}</td>
    <td>${w.contact_No}</td>
    <td>${w.aadhar_No}</td>
    <td>${w.house_No}</td>
    <td>${w.street}</td>
    <td>${w.area}</td>
    <td>${w.salary_per__annum}</td>
    <td>${w.joining_Date}</td>
    <td>${map.get(w.ms_id)}</td>
    <td><a href="/dbms_project/worker/editworker/${w.worker_ID}">Edit</a></td>
    <td><a href="/dbms_project/worker/editbank/${w.worker_ID}">Edit</a></td>
    <td><a href="/dbms_project/worker/deleteworker/${w.worker_ID}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a class="link" href="/dbms_project/worker/workerform">Add New Worker</a>
    </div>
    </body>