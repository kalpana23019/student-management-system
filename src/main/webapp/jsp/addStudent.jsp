<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        body{
            background-color:#f4f6f9;
        }

        .student-card{
            max-width:700px;
            margin:40px auto;
            padding:30px;
            background:white;
            border-radius:15px;
            box-shadow:0 0 15px rgba(0,0,0,0.1);
        }

        h2{
            text-align:center;
            margin-bottom:25px;
            color:#0d6efd;
        }

        .btn-save{
            width:100%;
        }

    </style>

</head>
<body>

<div class="container">

    <div class="student-card">

        <h2>Add Student</h2>

        <form action="../addStudent"
              method="post"
              enctype="multipart/form-data">

            <div class="mb-3">
                <label class="form-label">First Name</label>
                <input type="text"
                       class="form-control"
                       name="firstName"
                       required>
            </div>

            <div class="mb-3">
                <label class="form-label">Last Name</label>
                <input type="text"
                       class="form-control"
                       name="lastName"
                       required>
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email"
                       class="form-control"
                       name="email">
            </div>

            <div class="mb-3">
                <label class="form-label">Phone</label>
                <input type="text"
                       class="form-control"
                       name="phone">
            </div>

            <div class="mb-3">
                <label class="form-label">Gender</label>
                <select class="form-select"
                        name="gender">
                    <option>Male</option>
                    <option>Female</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Course</label>
                <input type="text"
                       class="form-control"
                       name="course">
            </div>

            <div class="mb-3">
                <label class="form-label">Address</label>
                <textarea class="form-control"
                          rows="3"
                          name="address"></textarea>
            </div>




            <div class="mb-3">
                <label class="form-label">Student Photo</label>
                <input type="file"
                       class="form-control"
                       name="photo">
            </div>

            <button type="submit"
                    class="btn btn-primary btn-save">
                Save Student
            </button>

        </form>

    </div>

</div>

</body>
</html>