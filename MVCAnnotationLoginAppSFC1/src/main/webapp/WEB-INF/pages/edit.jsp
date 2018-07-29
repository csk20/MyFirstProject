<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>EDIT Page</title>
  </head>
<body>


<div class="container">
<div class="row">

<div class="col-md-4 text-primary">


Edit Password

<br/>

<br/>


  

   
 ${oneUser.getUser()} <br/>  ${oneUser.getPwd()}<br/>


${uname}




    

<form:form  class="form-group" commandName="eCmd"   method="post" >

<label for="userid">UserId :</label>
 <form:input   path="user" class="form-control" id="userid"  /><form:errors path="user"/><br>
  
  
 
  <label for="pid">Password :</label>
<form:password path="pwd" class="form-control" id="pid"  placeholder="Enter new  Password"/><form:errors path="pwd"/><br>

<input type="submit" class="btn btn-primary" value="edit"><br><br>



</form:form>


${result}
<br/>
<br/>
<a class="text-info" href="register.htm">Register</a>
<br/>
<a class="text-info" href="list.htm">List</a>
<br/>
<a class="text-warning" href="report.htm?type=excel">ExcelDownload</a>
&nbsp;&nbsp;&nbsp;
<a class="text-warning" href="report.htm?type=pdf">PdfDownload</a>
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