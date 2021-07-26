<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="/web/">Socin</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="/web/">Usuários</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/web/developers">Desenvolvedores</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/logout" id="logout">Sair</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
<script>
const apiUrl = 'https://socin.herokuapp.com'

const DATATABLES_DEFAULTS = {
    serverSide: true,
    processing: true,
    searching: false,
    ordering: false,
    language: {
      url: 'https://cdn.datatables.net/plug-ins/1.10.25/i18n/Portuguese-Brasil.json'
    }
}
</script>
