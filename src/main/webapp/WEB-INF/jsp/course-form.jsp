<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Add/Edit Course</title>
    <link rel="stylesheet" href="/css/styles.css" />
  </head>
  <body>
    <div class="wrapper">
      <div class="navbar">
        <a href="/students">Students</a> |
        <a href="/courses">Courses</a>
      </div>

      <h2>Add/Edit Course</h2>

      <form action="/courses/save" method="post">
        <input type="hidden" name="id" value="${course.id}" />

        <label>Title:</label><br />
        <input
          type="text"
          name="title"
          value="${course.title}"
          required
        /><br /><br />

        <label>Description:</label><br />
        <input
          type="text"
          name="description"
          value="${course.description}"
          required
        /><br /><br />

        <input type="submit" value="Save" />
      </form>

      <br />
      <a href="/courses">Back to Courses List</a>
    </div>
  </body>
</html>
