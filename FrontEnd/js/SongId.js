const idSelect = document.getElementById('id');

fetch('http://localhost:8080/api/getSongs')
  .then(response => response.json())
  .then(data => {
    data.forEach(item => {
      const option = document.createElement('option');
      option.value = item.id;
      option.textContent = item.id;
      idSelect.appendChild(option);
    });
  })
  .catch(error => {
    console.error(error);
  });