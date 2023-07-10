
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

  // Display order details and OTP in a popup
  var orderSummary = orderText + "\nTotal Bill: ₹" + totalBill.toFixed(2) + "\n\nOTP: " + otp;
  alert("Order Placed!\n\n" + orderSummary);

  // Clear the cart and reset quantity to zero
  cartItems = {};
  updateCart();
}


//-------------------LOGIN POP UP------------------------
const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.login-link');
const signupLink = document.querySelector('.sign-up-link');
const btnpopup = document.querySelector('.btnLogin-popup')
const iconClose = document.querySelector('.icon-close')


signupLink.addEventListener('click', ()=>{
  wrapper.classList.add('active');
});

loginLink.addEventListener('click', ()=>{
  wrapper.classList.remove('active');
});

btnpopup.addEventListener('click', ()=>{
  wrapper.classList.add('active-popup');
});
iconClose.addEventListener('click', ()=>{
  wrapper.classList.remove('active-popup','active');
});

//------------------SIGN UP DATA ENTRY-------------------
document.getElementById("signup-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  // Get form data
  const username = document.getElementById("username").value;
  // const eateryId = document.getElementById("eatery-id").value;
  // const eateryName = document.getElementById("eatery-name").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  // Create an object to hold the form data
  const formData = {
    username: username,
    // eateryId: eateryId,
    // eateryName: eateryName,
    email: email,
    password: password
  };

  // Send form data to the Spring Boot backend
  fetch("/signup", {
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
  const password = document.getElementById("password").value;

  // Create an object to hold the form data
  const formData = {
    email: email,
    password: password
  };

  // Send form data to the Spring Boot backend
  fetch("/login", {
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