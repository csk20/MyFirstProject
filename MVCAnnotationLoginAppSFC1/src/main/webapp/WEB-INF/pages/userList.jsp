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

    <title>List</title>
  </head>
<body>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">S.N.</th>
      <th scope="col">  &nbsp;  UserName &nbsp; &nbsp;  </th>
      <th scope="col">&nbsp;  &nbsp;   Password  &nbsp;  </th>
       <th scope="col">  Delete </th>
       <th scope="col">   Edit  </th>
    </tr>
  </thead>
  <c:set var="count" value="0"  />
  <c:forEach items="${ulist}" var="item" varStatus="counter" >
  <tbody>
   <tr>
 <th scope="row">${counter.count}</th> <td> ${item.getUser()}</td><td> ${item.getPwd()}</td> 
 <td><a class="text-danger" href="delete.htm?user=${item.getUser()}">Delete</a></td>
 <td><a href="edit.htm?user=${item.getUser()}">Edit</a></td>
  </tr>
   <tr>
  </tbody>
    </c:forEach>
</table>




${success}

<%-- ${ulist} --%>
<br/>
<br/>
<a class="text-info" href="register.htm">Register</a>
<br/>





<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>



</body>
</html>