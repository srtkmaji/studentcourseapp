<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Students List</title>
    <link rel="stylesheet" href="/css/styles.css" />
  </head>
  <body>
    <div class="wrapper">
      <div class="navbar">
        <a href="/students">Students</a> |
        <a href="/courses">Courses</a>
      </div>

      <h2>Students</h2>
      <a href="/students/add" class="button">Add Student</a>
      <table border="1">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Course</th>
          <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${students}">
          <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>
              <c:if test="${student.course != null}">
                ${student.course.title}
              </c:if>
              <c:if test="${student.course == null}"> - </c:if>
            </td>
            <td>
              <a href="/students/edit/${student.id}" class="button">Edit</a>
              &nbsp;
              <a
                href="/students/delete/${student.id}"
                onclick="return confirm('Delete student?');"
                class="button"
                >Delete</a
              >
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
