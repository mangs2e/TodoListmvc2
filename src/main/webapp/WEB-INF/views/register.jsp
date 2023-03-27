<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap demo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
          crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand">Navbar</a>
  </div>
  </div>
</nav>

<section style="padding: 15px">
  <nav class="navbar-expand-lg bg-light">
    <div class="container-fluid" style="margin-bottom: 10px">
      <b>Featured</b>
    </div>
  </nav>
  <div class="card">
  <br>
  <form action="registerProcess" method="post">
  <div class="input-group mb-3">
    <span class="input-group-text">Title</span>
    <input type="text" class="form-control" name="title">
  </div>
  <div class="input-group mb-3" >
    <span class="input-group-text">DueDate</span>
    <input type="date" class="form-control" name="dueDate">
  </div>
  <div class="input-group mb-3">
    <span class="input-group-text">Writer</span>
    <input type="text" class="form-control" name="writer">
  </div>
    <input style="float: right; margin: 5px;" type="reset" class="btn btn-secondary" value="Reset">
    <input style="float: right; margin: 5px;" type="submit" class="btn btn-primary" value="Submit">
  </form>
  </div>
</section>
</body>
</html>