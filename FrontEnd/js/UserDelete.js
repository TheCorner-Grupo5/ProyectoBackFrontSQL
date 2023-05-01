const form = document.getElementById('user-form');

form.addEventListener('submit', function(event) {
	event.preventDefault();

	const user = {
		id: form.elements.id.value,
	};

	fetch('http://localhost:8080/api/deleteUser'+'?id='+user.id, {
		method: 'DELETE'
	})
	.then(response => response.json())
	.then(data => {
		console.log('Success:', data);
		
		// Reset the form
		form.reset();

		// Refresh the page after a delay of 1 second
		setTimeout(() => {
		  location.reload();
		});
	})
	.catch((error) => {
		console.error('Error:', error);
	});
});
