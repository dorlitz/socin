<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - Socin</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-3 mt-5 mx-auto">
            <h3>Faça o login</h3>
            <form action="/web/login" method="post">
                <div class="form-group mb-3">
                    <input type="text" class="form-control" placeholder="Seu e-mail" name="username">
                </div>
                <div class="form-group mb-3">
                    <input type="password" class="form-control" placeholder="Sua senha" name="password">
                </div>
                <div class="form-group text-end">
                    <button class="btn btn-primary">Login</button>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
