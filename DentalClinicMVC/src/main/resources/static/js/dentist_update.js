window.addEventListener('load', function () {
  const formulario = document.querySelector('#update_dentist_form');
  formulario.addEventListener('submit', function (event) {
    let dentistId = document.querySelector('#dentist_id').value;

    const formData = {
      id: document.querySelector('#dentist_id').value,
      firstName: document.querySelector('#firstName').value,
      lastName: document.querySelector('#lastName').value,
      registration: document.querySelector('#registration').value,
    };

    const url = '/api/dentists';
    const settings = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData)
    }
    fetch(url, settings)
        .then(response => response.json())

  })
})

function findBy(id) {
  const url = '/api/dentists' + "/" + id;
  const settings = {
    method: 'GET'
  }
  fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        let dentist = data;
        document.querySelector('#dentist_id').value = dentist.id;
        document.querySelector('#firstName').value = dentist.firstName;
        document.querySelector('#lastName').value = dentist.lastName;
        document.querySelector('#registration').value = dentist.registration;
        document.querySelector('#div_dentist_updating').style.display = "block";
      }).catch(error => {
    alert("Error: " + error);
  })
}
