const form = document.getElementById('song-form');

form.addEventListener('submit', function(event) {
	event.preventDefault();

	const user = {
		id: form.elements.id.value,
		firstName: form.elements.firstName.value,
		lastName: form.elements.lastName.value,
		email: form.elements.email.value,
		avatar: form.elements.avatar.value
	};

	fetch('http://localhost:8080/api/updateSong', {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
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