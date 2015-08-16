<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Player</title>
  </head>
  <body>
    <h1>Create Player</h1>

    <form:form method="POST" modelAttribute="playerForm">
      First Name(*): <input type="text" name="firstName" /><br/>
      Last Name(*): <input type="text" name="lastName" /><br/>
      Age (*): <input type="text" name="age" /><br/>
      Country(*): 
      <form:select path="countryOfBirth" >
        <form:option value="Canada" label="Canada" />
        <form:options items="${countries}" />
       </form:select>
      <br/>      
      Position(*): 
      <form:select path="position">
        <form:option value="Goalkeeper">Goalkeeper</form:option>
        <form:option value="Defender">Defender</form:option >
        <form:option value="Midfielder">Midfielder</form:option >
        <form:option value="Forward">Forward</form:option >        
      </form:select>      
      <br/>
      Annual Salary(*): <input type="text" name="amount" /><br/>
      Stats (*):<br/>
      Number of Goals: <input type="text" name="numOfGoals" /><br/>
      Number of Bookings: <input type="text" name="numOfBookings" /><br/>      
      <input type="submit" value="Create" name="create"/>
      <input type="submit" value="Cancel" name="cancel"/>      
    </form:form>
  </body>
</html>
