<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

    <title>Student Management System</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>

<div class="container">

    <div class="dashboard-card">

        <h1>🎓 Student Management System</h1>

        <p class="subtitle">
            Manage student records easily with CRUD operations,
            search, image upload and pagination.
        </p>

        <div class="menu">

            <a href="addStudent.jsp" class="btn add-btn">
                ➕ Add Student
            </a>

            <a href="../viewStudents" class="btn view-btn">
                📋 View Students
            </a>

        </div>

    </div>

</div>

</body>
</html>