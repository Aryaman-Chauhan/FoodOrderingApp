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


