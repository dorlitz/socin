$.ajaxSetup({
  contentType : 'application/json',
  processData : false
})

function getApiUrl(path) {
  return `${apiUrl}${path}`
}

function saveUser(data) {
  return new Promise(function (resolve, reject) {
    if (data.id) {
      $.ajax({
        url: getApiUrl(`/users/${data.id}`),
        data: JSON.stringify(data),
        type: 'PUT',
      })
      .done(resolve)
      .fail(reject)
      return
    }
    $.post(getApiUrl('/users'), JSON.stringify(data)).done(resolve).fail(reject)
    return
  })
}

function removeUser(id) {
  return new Promise(function (resolve, reject) {
    $.ajax({
      url: getApiUrl(`/users/${id}`),
      type: 'DELETE'
    }).done(resolve).fail(reject);
  })
}

window.loadUser = function (id) {
  return new Promise(function (resolve, reject) {
    $.get(getApiUrl(`/users/${id}`)).done(resolve).fail(reject)
  })
}

function logout() {
  return new Promise(function (resolve, reject) {
    $.post(getApiUrl('/logout')).done(resolve).fail(reject)
  })
}

$('#logout').click(async e => {
  e.preventDefault()
  await logout()
  window.location.href = '/'
})

$('#save-user').submit(async e => {
  e.preventDefault()
  const data = new FormData(e.target)
  try {
    await saveUser(Object.fromEntries(data.entries()))
    window.location.href = '/web/';
  } catch (e) {
    console.log('error', e)
  }
})

$('#user-datatable').on('click', '.remove-user', async e => {
  e.preventDefault()
  const id = $(e.target).data('id');
  if (id) {
    await removeUser(id)
    $('#datatable').DataTable().ajax.reload()
  }
})
