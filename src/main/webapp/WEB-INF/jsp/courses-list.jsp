<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Courses List</title>
    <link rel="stylesheet" href="/css/styles.css" />
  </head>
  <body>
    <div class="wrapper">
      <c:if test="${not empty errorMessage}">
        <div class="error-card">${errorMessage}</div>
      </c:if>

      <div class="navbar">
        <a href="/students">Students</a> |
        <a href="/courses">Courses</a>
      </div>

      <h2>Courses</h2>
      <a href="/courses/add" class="button">Add Course</a>
      <table border="1">
        <tr>
          <th>ID</th>
          <th>Title</th>
          <th>Description</th>
          <th>Actions</th>
        </tr>
        <c:forEach var="course" items="${courses}">
          <tr>
            <td>${course.id}</td>
            <td>${course.title}</td>
            <td>${course.description}</td>
            <td>
              <a href="/courses/edit/${course.id}" class="button">Edit</a>
              <a
                href="/courses/delete/${course.id}"
                onclick="return confirm('Delete course?');"
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
