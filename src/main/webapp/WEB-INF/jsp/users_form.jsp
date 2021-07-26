<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Usuários - Socin</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>
<body>

    <%@ include file="menu.jsp"%>

  <div class="container py-4">
    <h3>Usuários</h3>

    <div class="text-end">
      <a href="../" class="btn btn-secondary">Cancelar</a>
    </div>

    <form id="save-user">
      <input type="hidden" name="id">
      <div class="form-group mb-3">
        <label>Nome</label>
        <input type="text" class="form-control" name="name">
      </div>
      <div class="form-group mb-3">
        <label>E-mail</label>
        <input type="email" class="form-control" name="email">
      </div>
      <div class="form-group mb-3">
        <label>Senha</label>
        <input type="password" class="form-control" name="password">
        <div class="text-muted d-none" id="password-helper">Deixe em branco para não alterar</div>
      </div>
      <div class="form-group text-end">
        <button class="btn-primary btn">Salvar</button>
      </div>
    </form>

  </div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="/js/app.js"></script>
<script>
$(window).on('load', async function () {
  const params = new URLSearchParams(window.location.search);
  if (params.get('id')) {
    const user = await loadUser(params.get('id'))
    if (user.id) {
      $('input[name="name"]').val(user.name)
      $('input[name="email"]').val(user.email)
      $('input[name="id"]').val(user.id)
      $('#password-helper').css('display', 'block !important')
    }
  }
})
</script>
</body>
</html>
