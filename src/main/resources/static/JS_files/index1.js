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


//---------------------MENU PAGE-----------------------------
var cartItems = {};
var itemPrices = {
  'burger': 59,
  'chilliPotato': 99,
  'dosa': 89,
  'noodles': 59,
  'pizza': 119,
  'poori': 99,
  'sandwich': 59,
  'soup': 89,
  'cup': 29,
  'cone': 59,
  'familypack': 129,
};

function capitalizeFirstLetter(string) {
  return string.charAt(0).toUpperCase() + string.slice(1);
}

function increaseQuantity(itemId) {
  cartItems[itemId] = (cartItems[itemId] || 0) + 1;
  updateCart();
}

function decreaseQuantity(itemId) {
  if (cartItems[itemId]) {
    cartItems[itemId]--;
    if (cartItems[itemId] === 0) {
      delete cartItems[itemId];
    }
    updateCart();
  }
}

function updateCart() {
  var cartList = document.getElementById("food-cart");
  var totalBill = 0;
  cartList.innerHTML = "";

  for (var itemId in cartItems) {
    if (cartItems.hasOwnProperty(itemId)) {
      var listItem = document.createElement("li");
      listItem.innerText = capitalizeFirstLetter(itemId) + ' - Quantity: ' + cartItems[itemId];
      cartList.appendChild(listItem);
      totalBill += itemPrices[itemId] * cartItems[itemId];

      // Update quantity display for menu items
      var quantityDiv = document.getElementById('quantity-' + itemId);
      quantityDiv.textContent = cartItems[itemId];
    }
  }

  var totalBillElement = document.getElementById("total-bill");
  totalBillElement.innerText = totalBill.toFixed(2);

  // Reset quantity display for menu items with zero count
  var quantityElements = document.getElementsByClassName("quantity");
  for (var i = 0; i < quantityElements.length; i++) {
    var itemId = quantityElements[i].id.split('-')[1];
    if (!cartItems[itemId]) {
      quantityElements[i].textContent = '0';
    }
  }
}

function placeOrder() {
  if (Object.keys(cartItems).length === 0) {
    alert("Your cart is empty. Please add items before placing an order.");
    return;
  }

  var orderText = "Order Placed for:\n";
  var totalBill = 0;
  for (var itemId in cartItems) {
    if (cartItems.hasOwnProperty(itemId)) {
      orderText += capitalizeFirstLetter(itemId) + " - Quantity: " + cartItems[itemId] + "\n";
      totalBill += itemPrices[itemId] * cartItems[itemId];
    }
  }

  // Generate OTP
  var otp = Math.floor(1000 + Math.random() * 9000);

  var orderData = {
    orderText: orderText,
    totalBill: totalBill.toFixed(2),
    otp: otp
  };

  // Send the order data to the backend using a POST request
  fetch('/createOrder', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(orderData)
  })
    .then(function(response) {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error('Error placing order');
      }
    })
    .then(function(data) {
      // Handle the response from the server
      console.log(data);
      // You can display a success message or perform any other actions
    })
    .catch(function(error) {
      // Handle any errors
      console.error(error);
    });

  // Clear the cart and reset quantity to zero
  cartItems = {};
  updateCart();
}

//------------------SIGN UP DATA ENTRY-------------------
document.getElementById("signup-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  // Get form data
  const name = document.getElementById("name").value;
  // const eateryId = document.getElementById("eatery-id").value;
  // const eateryName = document.getElementById("eatery-name").value;
  const email = document.getElementById("email").value;
  const pass = document.getElementById("pass").value;

  // Create an object to hold the form data
  const formData = {
    name: name,
    // eateryId: eateryId,
    // eateryName: eateryName,
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
