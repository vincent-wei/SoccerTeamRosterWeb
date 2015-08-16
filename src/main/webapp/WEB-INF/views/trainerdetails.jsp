<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Trainer Details</title>
  </head>
  <body>
    <h1>Trainer Details</h1>
  <form:form method="POST" modelAttribute="trainerForm">
    First Name(*): <c:out value="${trainerForm.firstName}" /> <br/>    
    Last Name(*): <c:out value="${trainerForm.lastName}" /><br/>
    Age (*): <c:out value="${trainerForm.age}" /><br/>
    Country(*): <c:out value="${trainerForm.countryOfBirth}" /><br/>
    Annual Salary(*): 
    <fmt:formatNumber value="${trainerForm.amount}" type="currency" currencySymbol="${currencySymbol}"/><br/>
    <input type="submit" value="Return" name="cancel"/>
    </form:form>
  </body>
</html>
