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
    .then((response) => {
      if (!response.ok) {
        throw new Error("Server response was not ok");
      }
      return response.json();
    })
    .then((data) => {
    	
		
      if (data.password === user.password && data.email === user.email) {
        console.log("Valido");
        window.location.href = "../index.html";
      } else {
        console.log("NO");
	
      }
    })
    .catch((error) => {
      console.error(error);
    });
});
