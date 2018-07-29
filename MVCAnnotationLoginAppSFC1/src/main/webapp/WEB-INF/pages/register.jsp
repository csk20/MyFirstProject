<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Register</title>
  </head>
<body>

<div class="container">
<div class="row">

<div class="col-md-3 text-primary">



    

<form:form method="post"  class="form-group" commandName="regCmd" >

<label for="nid">Name :</label>
 <form:input   path="name" class="form-control" id="nid" placeholder="Enter Name"  /><br/>
  
  <label for="userid">UserId :</label>
 <form:input   path="userid" class="form-control" id="userid" placeholder="Enter Userid"  /><br/>
  
  
  <label for="pnid">Phone no: :</label>
 <form:input   path="phone" class="form-control" id="pnid" placeholder="Enter PhoneNumber"  /><br/>
  
 
  <label for="pid">Password :</label>
<form:password path="pwd" class="form-control" id="pid"  placeholder="Enter Password"/><br/>

 <label for="pid">Gender :</label>
<form:radiobutton path="gender"  value="M" checked="true"/>Male
<form:radiobutton path="gender"   value="F" />Female
<br/>
<input type="submit" class="btn btn-primary" value="Register"/> &nbsp;<div class="text-success">${result}</div>
</form:form>

<div class="text-info"> 
Click here if already registered: &nbsp;&nbsp;
<a class="text-default" href="login.htm">Login</a>
<br/>
<a class="text-info" href="home.htm">DownLoadPage</a>
</div>


</div>
</div>

</div>




<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>



</body>
</html>