<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&display=swap" rel="stylesheet">

<style>
:root {
  --input-padding-x: 1.5rem;
  --input-padding-y: 0.75rem;
}

.login,
.image {
  min-height: 100vh;
}

body {
  background-image: url('https://source.unsplash.com/OG44d93iNJk/600x1200');
  background-size: cover;
  background-position: center;
  font-family: 'Noto Sans JP', sans-serif;
}

.login-heading {
  font-weight: 300;
}

.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
  border-radius: 2rem;
}

.form-label-group {
  position: relative;
  margin-bottom: 1rem;
}

.form-label-group>input,
.form-label-group>label {
  padding: var(--input-padding-y) var(--input-padding-x);
  height: auto;
  border-radius: 2rem;
}

.form-label-group>label {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  margin-bottom: 0;
  /* Override default `<label>` margin */
  line-height: 1.5;
  color: #495057;
  cursor: text;
  /* Match the input under the label */
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
}

.form-label-group input::-webkit-input-placeholder {
  color: transparent;
}

.form-label-group input:-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-moz-placeholder {
  color: transparent;
}

.form-label-group input::placeholder {
  color: transparent;
}

.form-label-group input:not(:placeholder-shown) {
  padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
  padding-bottom: calc(var(--input-padding-y) / 3);
}

.form-label-group input:not(:placeholder-shown)~label {
  padding-top: calc(var(--input-padding-y) / 3);
  padding-bottom: calc(var(--input-padding-y) / 3);
  font-size: 12px;
  color: #777;
}
.btn-copy {
  background-color: DodgerBlue; /* Blue background */
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px 10px; /* Some padding */
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
}



@supports (-ms-ime-align: auto) {
  .form-label-group>label {
    display: none;
  }
  .form-label-group input::-ms-input-placeholder {
    color: #777;
  }
}



@media all and (-ms-high-contrast: none),
(-ms-high-contrast: active) {
  .form-label-group>label {
    display: none;
  }
  .form-label-group input:-ms-input-placeholder {
    color: #777;
  }
}

</style>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="/my/page">Tiny URL</a>
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav navbar-dark">
     
      <a class="nav-item nav-link" href="/">Home</a>
      <a class="nav-item nav-link" href="/login">Login</a>
      
    </div>
  </div>
</nav>
<div class="container-fluid">
  <div class="row no-gutter">

        <div class="container pt-5">
          <div class="row">
            <div class="text-center mx-auto">
              <h3 class="login-heading mb-4">Registration Page</h3>
              <form action="/signup/form" method="post">
               <label for="inputEmail">Username</label>
                <div class="form-label-group">
                 
                  <input type="text" id="inputEmail" class="form-control" name="name" placeholder="Username" autocomplete="off" required >
                  
                </div>
                <label for="inputEmail">Password</label>
                <div class="form-label-group">
                  <input type="password" id="myInput" class="form-control" name="password" placeholder="password">
                  
                  
                </div>
                	
                
                
                	<button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Register</button>
                
                  
              </form>
            </div>
          </div>
        </div>

</div>
<script>
function myFunction() {
  /* Get the text field */
  var copyText = document.getElementById("myInput");

  /* Select the text field */
  copyText.select();
  copyText.setSelectionRange(0, 99999); 
  document.execCommand("copy");


}
</script>

</body>
</html> 