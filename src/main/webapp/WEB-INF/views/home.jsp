<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Football App</title>
  </head>
  <body>
    <h1>Welcome to Football App</h1>

    <a href="<c:url value="/createplayer" />">Create Player</a> | 
    <a href="<c:url value="/createtrainer" />">Create Trainer</a>
  </body>
</html>
