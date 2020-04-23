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
	<h1>Doctor List</h1>
	<table id="tab">
	<tr><th>Id</th><th>Name</th><th>Contact No.</th><th>Clinic Name</th><th>Major Location</th><th>Commision per recommendation</th><th>Edit Bank</th><th>Delete</th></tr>
    <c:forEach var="w" items="${list}"> 
    <tr>
    <td>${w.doctor_ID}</td>
    <td>${w.name}</td>
    <td>${w.contact_No}</td>
    <td>${w.clinic_Name}</td>
    <td>${w.major_Location}</td>
    <td>${w.commision_per__recommendation}</td>
    <td><a href="/dbms_project/doctor/editbank/${w.doctor_ID}">Edit</a></td>
    <td><a href="/dbms_project/doctor/deletedoctor/${w.doctor_ID}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a class="link" href="/dbms_project/doctor/doctorform">Add New Doctor</a>
    </div>
    </body>