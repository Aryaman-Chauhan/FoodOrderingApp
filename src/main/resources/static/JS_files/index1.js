//Initialize Firebase with your project credentials

var firebaseConfig = {
  apiKey: "AIzaSyCWhO6lkeL003HhucHFcAyE5ApWNPrToEA",
  authDomain: "oop-webapp-bits.firebaseapp.com",
  databaseURL: "https://oop-webapp-bits-default-rtdb.firebaseio.com",
  projectId: "oop-webapp-bits",
  storageBucket: "oop-webapp-bits.appspot.com",
  messagingSenderId: "878639828232",
  appId: "1:878639828232:web:9948021e1c0b3772aa30bd",
  measurementId: "G-X05F5Q19B4"
};
    firebase.initializeApp(firebaseConfig);

    // Get a reference to the Firestore database
    var db = firebase.firestore();


//------------------SIGN UP DATA ENTRY-------------------
document.getElementById("signup-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  // Get form data
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const pass = document.getElementById("pass").value;

  // Create an object to hold the form data
  const formData = {
    name: name,
    email: email,
    pass: pass
  };

  // Send form data to the Spring Boot backend
  fetch("/createStudent", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(formData)
  })
  .then(response => {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error("Error occurred during signup.");
    }
  })
  .then(data => {
    // Handle the server response
    console.log(data);
    // You can perform further actions based on the response
  })
  .catch(error => {
    // Handle any errors
    console.error(error);
  });
});

//------------------LOGIN DATA--------------------

document.getElementById("login-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  // Get form data
  const email = document.getElementById("email").value;
  const pass = document.getElementById("pass").value;

  // Create an object to hold the form data
  const formData = {
    email: email,
    pass: pass
  };

  // Send form data to the Spring Boot backend
  fetch("/getStudent", {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(formData)
  })
  .then(response => {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error("Error occurred during login.");
    }
  })
  .then(data => {
    // Handle the server response
    console.log(data);
    // You can perform further actions based on the response
  })
  .catch(error => {
    // Handle any errors
    console.error(error);
  });
});

// ------------------ qUERY FOR ORDER DATA RETRIEVAL-------------------------
// Function to create nested divs with different class names
function createNestedDivs(level, parentDiv, data, className) {
  var currentDiv = document.createElement("div");
  currentDiv.className = className; // Set the class name for the current div

  if (level === 1) {
    currentDiv.classList.add("food-items"); // Add additional class for specific styling
    currentDiv.innerHTML = `
      <h5>Order Placed For:</h5>
      <br>
      <p>${data.order}</p>
      <h5>Total Bill: &#8377; ${data.totalBill}</h5>
    `;
  } else {
    currentDiv.textContent = "Level " + level + " Data: " + JSON.stringify(data);
  }

  parentDiv.appendChild(currentDiv);

  if (level < 4) {
    var nestedData = data["level" + (level + 1)];
    var nestedClassName = "nested-div-level-" + (level + 1); // Generate different class name for each level
    createNestedDivs(level + 1, currentDiv, nestedData, nestedClassName);
  }
}

// Function to retrieve data and create nested divs with different class names
function retrieveDataAndCreateDivs() {
  var menuDiv = document.querySelector(".menu");

  db.collection("Order")
    .get()
    .then(function (querySnapshot) {
      querySnapshot.forEach(function (doc, index) {
        var docData = doc.data();
        var className = "nested-div-level-1-" + (index + 1); // Generate different class name for each document
        createNestedDivs(1, menuDiv, docData, className);
      });
    })
    .catch(function (error) {
      console.error("Error retrieving data:", error);
    });
}

// Call the function to retrieve data and create divs with different class names
retrieveDataAndCreateDivs();
