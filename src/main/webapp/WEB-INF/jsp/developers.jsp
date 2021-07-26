<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Desenvolvedores - Socin</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap5.min.css">
</head>
<body>

    <%@ include file="menu.jsp"%>

    <div class="container py-4">
        <h3 class="mb-4">Desenvolvedores</h3>

        <table id="datatable">
            <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>Login</th>
                    <th>URL</th>
                </tr>
            </thead>
        </table>
    </div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script>
$('#datatable').dataTable({
    ...DATATABLES_DEFAULTS,
    ajax: apiUrl + '/developers-custom',
    columns: [
        {
            searchable: false,
            sortable: false,
            data: 'avatarUrl',
            render: data => {
                return '<img src="' + data + '" class="rounded-circle" style="width: 70px">'
            }
        },
        { searchable: false, sortable: false, data: 'id' },
        { searchable: false, sortable: false, data: 'login' },
        { searchable: false, sortable: false, data: 'htmlUrl', render: data => {
                return '<a target="_blank" href="' + data + '">' + data + '</a>'
            }
        },
    ]
});
</script>
</body>
</html>
