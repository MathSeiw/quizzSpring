<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--<%@ page isELIgnored="false" %>-->
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>

	<div class="container">
		<h2 class="form-signin-heading">
			<spring:message code="quizz.title" />
		</h2>
		<spring:message code="success.hello" arguments="${user.username}" />
		<br />
		<form:form class="form-signin" method="POST" modelAttribute="quizz"
			action="verifquizz">
			<c:forEach items="${quizz.listquestions}" var="question"
				varStatus="status">
				<c:out value="${question.question}" />
				<input type="text" name="myValues" />
				<input name="listquestions[${status.index}].question" value="${question.question}"/>
				<input name="listquestions[${status.index}].response" value="${question.response}"/>
			</c:forEach>
			<form:button id="enter" name="enter">
				<spring:message code="quizz.end" />
			</form:button>
		</form:form>
	</div>
	<!-- /.container -->
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>