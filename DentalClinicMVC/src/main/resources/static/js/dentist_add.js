window.addEventListener('load', function () {
  const formulario = document.querySelector('#add_new_dentist');

  formulario.addEventListener('submit', function (event) {

    const formData = {
      firstName: document.querySelector('#firstName').value,
      lastName: document.querySelector('#lastName').value,
      registration: document.querySelector('#registration').value,

    };
    const url = '/api/dentists';
    const settings = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData)
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
          let successAlert = '<div class="alert alert-success alert-dismissible">' +
              '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
              '<strong></strong> Odontólogo agregado </div>'

          document.querySelector('#response').innerHTML = successAlert;
          document.querySelector('#response').style.display = "block";
          resetUploadForm();

        })
        .catch(error => {
          let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
              '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
              '<strong> Error intente nuevamente</strong> </div>'

          document.querySelector('#response').innerHTML = errorAlert;
          document.querySelector('#response').style.display = "block";
          resetUploadForm();
        })
  });

  function resetUploadForm() {
    document.querySelector('#firstName').value = "";
    document.querySelector('#lastName').value = "";
    document.querySelector('#registration').value = "";

  }

  (function () {
    let pathname = window.location.pathname;
    if (pathname === "/") {
      document.querySelector(".nav .nav-item a:first").addClass("active");
    } else if (pathname == "/dentists.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })();
});
