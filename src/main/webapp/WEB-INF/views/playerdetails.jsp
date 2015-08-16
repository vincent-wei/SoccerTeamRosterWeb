<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Player Details</title>
  </head>
  <body>
    <h1>Player Details</h1>
  <form:form method="POST" modelAttribute="playerForm">
    First Name(*): <c:out value="${playerForm.firstName}" /> <br/>    
    Last Name(*): <c:out value="${playerForm.lastName}" /><br/>
    Age (*): <c:out value="${playerForm.age}" /><br/>
    Country(*): <c:out value="${playerForm.countryOfBirth}" /><br/>
    Position(*): <c:out value="${playerForm.position}" /><br/>
    Annual Salary(*): 
    <fmt:formatNumber value="${playerForm.amount}" type="currency" currencySymbol="${currencySymbol}"/><br/>
    Stats (*):<br/> 
    <c:out value="${playerForm.numOfGoals}" /> Goals, &nbsp;<c:out value="${playerForm.numOfBookings}" /> Bookings <br/>
    <input type="submit" value="Return" name="cancel"/>
    </form:form>
  </body>
</html>
