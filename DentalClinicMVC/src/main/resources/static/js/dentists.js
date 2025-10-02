window.addEventListener('load', function () {
  (function () {

    const url = '/api/dentists';
    const settings = {
      method: 'GET'
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
          let dentist;
          for (dentist of data) {
            let table = document.getElementById("dentistTable");
            let dentistRow = table.insertRow();
            dentistRow.id = 'tr_' + dentist.id;

            let deleteButton = '<button' +
                ' id=' + '\"' + 'btn_delete_' + dentist.id + '\"' +
                ' type="button" onclick="deleteBy(' + dentist.id + ')" class="btn btn-danger btn_delete">' +
                '&times' +
                '</button>';

            let updateButton = '<button' +
                ' id=' + '\"' + 'btn_id_' + dentist.id + '\"' +
                ' type="button" onclick="findBy(' + dentist.id + ')" class="btn btn-info btn_id">' +
                dentist.id +
                '</button>';

            dentistRow.innerHTML = '<td>' + updateButton + '</td>' +
                '<td class=\"td_id\">' + dentist.id + '</td>' +
                '<td class=\"td_registration\">' + dentist.registration + '</td>' +
                '<td class=\"td_firstName\">' + dentist.firstName.toUpperCase() + '</td>' +
                '<td class=\"td_lastName\">' + dentist.lastName.toUpperCase() + '</td>' +
                '<td>' + deleteButton + '</td>'
            ;
          }
        })
  })

  (function () {
    let pathname = window.location.pathname;
    if (pathname === "/dentists.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })
})
