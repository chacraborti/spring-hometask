<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h3>Events</h3>
	<c:forEach var = "i" begin = "1" end = "5">
             Item <c:out value = "${i}"/><p>
          </c:forEach>
</body>
</html>