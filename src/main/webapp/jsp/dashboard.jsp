<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Admin" %>

<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }

    Admin admin = (Admin) session.getAttribute("admin");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Student Management System</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
      <style>

      *{
          margin:0;
          padding:0;
          box-sizing:border-box;
          font-family:Arial, Helvetica, sans-serif;
      }

      body{
          background:linear-gradient(135deg,#4facfe,#00f2fe);
          min-height:100vh;
          display:flex;
          justify-content:center;
          align-items:center;
      }

      .container{
          width:100%;
          display:flex;
          justify-content:center;
          align-items:center;
      }

      .dashboard-card{
          width:750px;
          background:#fff;
          padding:35px;
          border-radius:20px;
          box-shadow:0 15px 35px rgba(0,0,0,0.2);
      }

      .dashboard-card h1{
          color:#0d6efd;
          font-size:34px;
          font-weight:bold;
          margin-bottom:8px;
      }

      .subtitle{
          color:#666;
          font-size:16px;
          line-height:25px;
      }

      .menu{
          display:flex;
          justify-content:center;
          gap:20px;
          margin-top:30px;
      }

      .btn{
          padding:14px 30px;
          border-radius:10px;
          font-size:18px;
          font-weight:bold;
          text-decoration:none;
          color:white;
          transition:0.3s;
      }

      .add-btn{
          background:#198754;
      }

      .add-btn:hover{
          background:#157347;
          transform:translateY(-3px);
      }

      .view-btn{
          background:#0d6efd;
      }

      .view-btn:hover{
          background:#0b5ed7;
          transform:translateY(-3px);
      }

      .logout-btn{
          background:#dc3545;
          padding:10px 22px;
          border-radius:8px;
          color:white !important;
      }

      .logout-btn:hover{
          background:#bb2d3b;
          transform:translateY(-2px);
      }

      hr{
          margin:25px 0;
      }

      </style>

</head>

<body>

<div class="container">

    <div class="dashboard-card">

        <!-- Header -->
        <div class="d-flex justify-content-between align-items-center">

            <div>
                <h1>🎓 Student Management System</h1>
                <p class="subtitle">
                    Welcome,
                    <strong><%= admin.getName() %></strong>
                </p>
            </div>

            <div>
                <a href="<%=request.getContextPath()%>/logout"
                   class="btn logout-btn">
                     Logout
                </a>
            </div>

        </div>

        <hr>

        <p class="subtitle">
            Manage student records easily with CRUD operations,
            search, image upload and pagination.
        </p>

        <div class="menu">

            <a href="addStudent.jsp" class="btn add-btn">
                ➕ Add Student
            </a>

            <a href="<%=request.getContextPath()%>/viewStudents"
               class="btn view-btn">
                📋 View Students
            </a>

        </div>

    </div>

</div>

</body>

</html>