<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

    body{
        background:#f4f6f9;
    }

    .card{
        margin-top:30px;
        padding:20px;
        border-radius:15px;
        box-shadow:0 0 15px rgba(0,0,0,0.1);
        background:white;
    }

    .student-photo{
        width:70px;
        height:70px;
        object-fit:cover;
        border-radius:50%;
        border:2px solid #ddd;
    }

    h2{
        color:#0d6efd;
    }

</style>
<body>

<div class="card">
<div class="d-flex justify-content-between align-items-center mb-3">

<h2>All Students</h2>

 <a href="<%=request.getContextPath()%>/jsp/addStudent.jsp" class="btn btn-success"> Add Student </a>
 </div>

 <form action="<%=request.getContextPath()%>/searchStudent" method="get" class="row g-2 mb-3">
 <div class="col-md-4"> <input type="text" name="keyword" class="form-control" placeholder="Search by Name or Course">
  </div>
  <div class="col-auto">
   <button type="submit" class="btn btn-primary"> Search </button>
    <a href="<%=request.getContextPath()%>viewStudents" class="btn btn-secondary"> Reset </a>
    </div>
     </form>
     <table class="table table-bordered table-striped table-hover">
      <thead class="table-dark">

       <tr>
      <th>ID</th>
       <th>Photo</th>
        <th>Name</th>
       <th>Email</th>
       <th>Course</th>
       <th>Actions</th>
       </tr>
       </thead>
       <tbody>

           <% List<Student> students = (List<Student>) request.getAttribute("students");
                 if (students != null) { for (Student s : students) { %> <tr> <td><%=s.getStudentId()%>
       </td>
       <td>
       <img src="<%=request.getContextPath()%>/images/<%=s.getPhoto()%>"
width="80"
height="80">
 </td>
        <td>
        <%=s.getFirstName()%>
         <%=s.getLastName()%>
        </td>
        <td><%=s.getEmail()%>
        </td>

        <td>
        <%=s.getCourse()%>

        </td>

        <td>
        <a class="btn btn-warning btn-sm" href="<%=request.getContextPath()%>/editStudent?id=<%=s.getStudentId()%>"> Edit </a>

         <a class="btn btn-danger btn-sm" href="<%=request.getContextPath()%>/deleteStudent?id=<%=s.getStudentId()%>"
          onclick="return confirm('Delete this student?')"> Delete </a>
           </td>
            </tr>
             <% } } %>
          </tbody>
           </table>
            </div>
</body>
</html>