<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Add/Edit Student</title>
    <link rel="stylesheet" href="/css/styles.css" />
  </head>
  <body>
  <div class="wrapper">
  <div class="navbar">
    <a href="/students">Students</a> |
    <a href="/courses">Courses</a>
  </div>

    <h2>Add/Edit Student</h2>
    <form action="/students/save" method="post">
        <input type="hidden" name="id" value="${student.id}" />
        Name: <input type="text" name="name" value="${student.name}" /><br/>
        Email: <input type="text" name="email" value="${student.email}" /><br/>
        Course:
        <select name="course.id">
            <c:forEach var="c" items="${courses}">
            <option value="${c.id}" <c:if test="${student.course != null && student.course.id == c.id}">selected</c:if>>${c.title}</option>
            </c:forEach>
        </select><br/>
        <input type="submit" value="Save" />
    </form>

    <a href="/students">Back to List</a>
  </div>
  </body>
</html>
