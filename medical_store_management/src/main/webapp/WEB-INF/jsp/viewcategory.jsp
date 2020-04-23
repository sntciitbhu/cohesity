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
	<h1>Category List</h1>
	<table id="tab">
	<tr><th>Id</th><th>Category Name</th><th>Delete</th></tr>
    <c:forEach var="cat" items="${list}"> 
    <tr>
    <td>${cat.category_Id}</td>
    <td>${cat.category_Name}</td>
    <td><a href="/dbms_project/category/deletecategory/${cat.category_Id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a  class="link" href="/dbms_project/category/categoryform">Add New Category</a>
    </div>
    </body>