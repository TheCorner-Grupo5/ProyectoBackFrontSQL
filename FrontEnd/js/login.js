const loginForm = document.getElementById("login-form");

loginForm.addEventListener("submit", function (event) {
  event.preventDefault();

  const formData = new FormData(loginForm);

  const user = {
    email: loginForm.elements.email.value,
    password: loginForm.elements.password.value,
  };

  fetch(
    `http://localhost:8080/api/login?email=${user.email}&password=${user.password}`,
    {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    }
  )
  .then(response => response.json())
	.then(data => {
		console.log('Success:', data);
    	
      if (data.email == user.email && data.password == user.password) {
        console.log("Valido");
        
        if (data.role.administrator == true && data.role.regularUser == true) {
          window.location.href = "AdminUserDashboard.html";
        } else if (data.role.administrator == true && data.role.regularUser == false) {
          window.location.href = "AdminDashboard.html";
        } else if (data.role.administrator == false && data.role.regularUser == true) {
          window.location.href = "UserDashboard.html";
        }

      } else {
        console.log("NO");
      }
    })
    .catch((error) => {
      console.error(error);
    });
});
