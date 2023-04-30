const form = document.getElementById('user-form');

form.addEventListener('submit', function(event) {
	event.preventDefault();

	const song = {
		id: form.elements.id.value,
	};

	fetch('http://localhost:8080/api/deleteUser'+'?id='+song.id, {
		method: 'DELETE'
	})
	.then(response => response.json())
	.then(data => {
		console.log('Success:', data);
	})
	.catch((error) => {
		console.error('Error:', error);
	});
});