<%@ taglib prefix="c"   uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"   %>
<%@ taglib prefix="fn"  uri="jakarta.tags.functions" %>
<html>
<head><title>Appointments</title></head>
<body>
  <h2>All Appointments</h2>
  <a href="${pageContext.request.contextPath}/appointments/new">New Appointment</a>
  <ul>
    <c:forEach var="appt" items="${appointments}">
      <li>
        ${appt.clientName} – 
        ${appt.startTime} to ${appt.endTime} 
        (<c:out value="${appt.notes}"/>) 
      </li>
    </c:forEach>
  </ul>
</body>
</html>
