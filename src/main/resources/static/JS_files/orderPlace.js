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
    var orderSummary = orderText + "\nTotal Bill: ₹" + totalBill.toFixed(2) + "\n\nOTP: " + otp;
    alert("Order Placed!\n\n" + orderSummary);
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