const form = document.getElementById('song-form');

form.addEventListener('submit', function(event) {
	event.preventDefault();

	const song = {
		firstName: form.elements.firstName.value,
		lastName: form.elements.lastName.value,
		email: form.elements.email.value,
		avatar: form.elements.avatar.value
	};

	fetch('http://localhost:8080/api/addSong', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(song)
	})
	.then(response => response.json())
	.then(data => {
		console.log('Success:', data);
	})
	.catch((error) => {
		console.error('Error:', error);
	});
});