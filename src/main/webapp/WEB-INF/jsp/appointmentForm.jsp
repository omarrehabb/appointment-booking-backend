<%@ taglib prefix="c"   uri="jakarta.tags.core"  %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"   %>
<%@ taglib prefix="fn"  uri="jakarta.tags.functions" %>
<html>
<head><title>Book Appointment</title></head>
<body>
  <h2>New Appointment</h2>
  <form action="${pageContext.request.contextPath}/appointments" method="post">
    Client Name: <input type="text" name="clientName"/><br/>
    Start Time: <input type="datetime-local" name="startTime"/><br/>
    End Time: <input type="datetime-local" name="endTime"/><br/>
    Notes: <textarea name="notes"></textarea><br/>
    <button type="submit">Book</button>
  </form>
</body>
</html>
