<%@ page import="model.Student" %>

<%
Student s = (Student) request.getAttribute("student");
%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

    body{
        background:#f4f6f9;
    }

    .student-card{
        max-width:800px;
        margin:40px auto;
        padding:30px;
        background:white;
        border-radius:15px;
        box-shadow:0 0 15px rgba(0,0,0,0.1);
    }

    h2{
        text-align:center;
        color:#0d6efd;
        margin-bottom:25px;
    }

</style>
<html>
<body>



<div class="student-card">

<h2>Edit Student</h2>


<form action="<%=request.getContextPath()%>/updateStudent" method="post" enctype="multipart/form-data">

 <input type="hidden" name="studentId" value="<%=s.getStudentId()%>">

 <input type="hidden" name="oldPhoto" value="<%=s.getPhoto()%>">


  <div class="row"> <div class="col-md-6 mb-3">
  <label class="form-label"> First Name </label>
  <input type="text" class="form-control" name="firstName" value="<%=s.getFirstName()%>" required>
   </div>

   <div class="col-md-6 mb-3">
   <label class="form-label"> Last Name </label>
    <input type="text" class="form-control" name="lastName" value="<%=s.getLastName()%>" required>
     </div>
      </div>


       <div class="mb-3">
      <label class="form-label"> Email </label>
       <input type="email" class="form-control" name="email" value="<%=s.getEmail()%>">
        </div>

         <div class="mb-3">
        <label class="form-label"> Phone </label>
        <input type="text" class="form-control" name="phone" value="<%=s.getPhone()%>">
        </div>

        <div class="mb-3">

         <label class="form-label"> Gender </label>

         <select class="form-select" name="gender">
         <option value="Male" <%= "Male".equals(s.getGender()) ? "selected" : "" %>> Male </option>
         <option value="Female" <%= "Female".equals(s.getGender()) ? "selected" : "" %>> Female </option>
          </select>

           </div>

            <div class="mb-3">
          <label class="form-label"> Course </label>
          <input type="text" class="form-control" name="course" value="<%=s.getCourse()%>">
          </div>

          <div class="mb-3">
           <label class="form-label"> Address </label>
           <textarea class="form-control" rows="3" name="address"><%=s.getAddress()%></textarea>
           </div>





          <div class="mb-3">
            <label class="form-label">Current Photo</label>
            <br>
            <img src="<%=request.getContextPath()%>/images/<%=s.getPhoto()%>" width="120" heighr="120"
            style ="border-radius:10px;">
            </div>

            <div class="mb-3">
            <label class="form=lable">New Photo</label>
            <input type="file" class="form-control" name="photo">
          </div>




           <div class="d-flex gap-2">
            <button type="submit" class="btn btn-primary"> Update Student </button>
            <a href="../viewStudents" class="btn btn-secondary"> Back </a>
            </div>

             </form>
 </div>
</body>
</html>