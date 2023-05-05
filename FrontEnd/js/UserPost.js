const form = document.getElementById('user-form');

form.addEventListener('submit', function(event) {
	event.preventDefault();

	const user = {
		firstName: form.elements.firstName.value,
		lastName: form.elements.lastName.value,
		email: form.elements.email.value,
		password: form.elements.password.value
	};

	fetch('http://localhost:8080/api/addUser', {
		method: 'POST',
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