// Import the functions you need from the SDKs you need
// import { initializeApp } from "firebase/app";
// import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
// const firebaseConfig = {
//   apiKey: "AIzaSyAMwwFDssC3yNpLSuhpbcxo_DonwHx3mag",
//   authDomain: "oop-project-bf8eb.firebaseapp.com",
//   projectId: "oop-project-bf8eb",
//   storageBucket: "oop-project-bf8eb.appspot.com",
//   messagingSenderId: "251672683615",
//   appId: "1:251672683615:web:257f79229ed64f2fffe7ea",
//   measurementId: "G-8RLXBGPKKZ"
// };

// Initialize Firebase
// const app = initializeApp(firebaseConfig);
// const analytics = getAnalytics(app);

// const express = require("express");
// const bodyparser = require("body-parser");
// const menuBtn = document.querySelector(".menu-btn")
// const navigation = document.querySelector(".navigation")

// menuBtn.addEventListener("click", ()=>{
//     menuBtn.classList.toggle("active");
//     navigation.classList.toggle("active");
// });
//--------------------DATA RENDERING--------------------



// -------------------ACTIVE LINK-----------------------
const activePage = window.location.pathname;
const navLinks = document.querySelectorAll('.nav-link');
navLinks.forEach(link => {
  if (link.href.includes(activePage)) {
    link.classList.add('active');
  }
});


//----------------HOME PAGE VIDEO SLIDER------------------------------
const btns = document.querySelectorAll(".nav-btn");
const slides = document.querySelectorAll(".video-slide");

var sliderNav = function(manual){
    btns.forEach((btn) =>{
        btn.classList.remove("active");
    });
    slides.forEach((slide) =>{
        slide.classList.remove("active");
    });


    btns[manual].classList.add("active");
    slides[manual].classList.add("active");
}

btns.forEach((btn, i) => {
    btn.addEventListener("click", () =>{
        sliderNav(i);
    });
});


//-------------------HOME PAGE LOGIN------------------------
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



//-------------------EATERY ORDER PAGE---------------------------------------
// Countdown Timer
function startTimer(duration, display) {
  var timer = duration, minutes, seconds;
  setInterval(function () {
    minutes = parseInt(timer / 60, 10);
    seconds = parseInt(timer % 60, 10);

    minutes = minutes < 10 ? "0" + minutes : minutes;
    seconds = seconds < 10 ? "0" + seconds : seconds;

    display.textContent = minutes + ":" + seconds;

    if (--timer < 0) {
      timer = 0;
    }
  }, 1000);
}

var cancelTimer3 = document.getElementById("cancel-timer-3");
startTimer(150, cancelTimer3);

var cancelTimer4 = document.getElementById("cancel-timer-4");
startTimer(150, cancelTimer4);

//------------------SIGN UPDATA ENTRY-------------------
document.getElementById("signup-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  // Get form data
  const username = document.getElementById("username").value;
  const eateryId = document.getElementById("eatery-id").value;
  const eateryName = document.getElementById("eatery-name").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  // Create an object to hold the form data
  const formData = {
    username: username,
    eateryId: eateryId,
    eateryName: eateryName,
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

// -----------------------ADD ITEM DATA------------------------
document.getElementById("item-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  // Retrieve form values
  const itemName = document.getElementById("item-name").value;
  const itemPrice = document.getElementById("item-price").value;
  const itemDescription = document.getElementById("item-description").value;
  const itemPhoto = document.getElementById("item-photo").files[0];

  // Perform validation if needed

  // Prepare form data to send to the server
  const formData = new FormData();
  formData.append("itemName", itemName);
  formData.append("itemPrice", itemPrice);
  formData.append("itemDescription", itemDescription);
  formData.append("itemPhoto", itemPhoto);

  // Send the form data to the server (replace with your endpoint URL)
  fetch("your-server-endpoint", {
    method: "POST",
    body: formData
  })
    .then(response => response.json())
    .then(data => {
      // Handle the response from the server
      console.log(data);
      // Display a success message or perform any additional actions
    })
    .catch(error => {
      // Handle any errors
      console.error(error);
    });
});