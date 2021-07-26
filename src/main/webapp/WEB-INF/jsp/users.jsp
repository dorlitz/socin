<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Início - Socin</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap5.min.css">
</head>
<body>

    <%@ include file="menu.jsp"%>

    <div class="container py-4">
        <h3 class="mb-4">Usuários</h3>

        <div class="text-end">
            <a href="/web/users/form" class="btn btn-primary">Novo usuário</a>
        </div>

        <div id="user-datatable">
            <table id="datatable">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>E-mail</th>
                        <th></th>
                    </tr>
                </thead>
            </table>
        </div>

    </div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script src="/js/app.js"></script>
<script>
$('#datatable').dataTable({
    ...DATATABLES_DEFAULTS,
    serverSide: false,
    ajax: {
        url: apiUrl + "/users",
        dataSrc: ""
    },
    columns: [
        { searchable: false , sortable: false, data: 'name'},
        { searchable: false , sortable: false, data: 'email'},
        { searchable: false , sortable: false, data: 'id', render: (id, type, row) => {
            return '<a href="/web/users/form?id='+id+'">Editar</a> / <a href="#" class="remove-user" data-id="'+id+'">Remover</a>'
        }},
    ]
});
</script>
</body>
</html>
