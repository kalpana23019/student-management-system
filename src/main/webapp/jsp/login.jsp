<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Admin Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{

    height:100vh;

    display:flex;

    justify-content:center;

    align-items:center;

    background:linear-gradient(135deg,#63b3ff,#1f6fe5);

}

/* Main Card */

.login-container{

    width:900px;

    height:520px;

    display:flex;

    border-radius:20px;

    overflow:hidden;

    background:#fff;

    box-shadow:0 20px 40px rgba(0,0,0,.25);

}

/* Left Side */

.left-panel{

    width:45%;

    background:linear-gradient(135deg,#0d6efd,#0056d6);

    color:white;

    padding:60px 40px;

    display:flex;

    flex-direction:column;

    justify-content:center;

}

.left-panel h1{

    font-size:38px;

    margin-bottom:20px;

}

.left-panel p{

    line-height:28px;

    font-size:17px;

    opacity:.95;

}

/* Right Side */

.right-panel{

    width:55%;

    padding:50px;

    display:flex;

    flex-direction:column;

    justify-content:center;

}

.right-panel h2{

    color:#0d6efd;

    text-align:center;

    margin-bottom:10px;

    font-size:35px;

}

.subtitle{

    text-align:center;

    color:#666;

    margin-bottom:30px;

}

.form-control{

    height:48px;

    border-radius:8px;

}

.btn-login{

    width:100%;

    height:48px;

    border:none;

    border-radius:8px;

    background:#0d6efd;

    color:white;

    font-size:18px;

    font-weight:bold;

    transition:.3s;

}

.btn-login:hover{

    background:#0056d6;

}

.alert{

    margin-bottom:20px;

}

</style>

</head>

<body>

<div class="login-container">

    <!-- Left Panel -->

    <div class="left-panel">

        <h1>🎓 Student Management System</h1>

        <p>

            Welcome to the Student Management System.

            <br><br>

            Manage student records using CRUD operations,
            image upload, search, pagination and secure
            admin authentication.

        </p>

    </div>

    <!-- Right Panel -->

    <div class="right-panel">

        <h2>Admin Login</h2>

        <p class="subtitle">

            Login with your administrator account

        </p>

        <%
            String error = (String) request.getAttribute("error");

            if(error != null){
        %>

        <div class="alert alert-danger">

            <%= error %>

        </div>

        <%
            }
        %>

        <form action="<%=request.getContextPath()%>/login"
              method="post"
              autocomplete="off">

            <div class="mb-3">

                <label class="form-label">Email</label>

                <input type="email"
                       class="form-control"
                       name="email"
                       placeholder="Enter Email"
                       autocomplete="off"
                       required>

            </div>

            <div class="mb-4">

                <label class="form-label">Password</label>

                <input type="password"
                       class="form-control"
                       name="password"
                       placeholder="Enter Password"
                       autocomplete="new-password"
                       required>

            </div>

            <button type="submit" class="btn-login">

                Login

            </button>

        </form>

    </div>

</div>

</body>

</html>