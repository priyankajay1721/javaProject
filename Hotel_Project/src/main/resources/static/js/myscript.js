function toggleDropdown() {
    document.getElementById("dropdownMenu").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}


// menu card
document.addEventListener('DOMContentLoaded', function() {
    const breakfastBtn = document.getElementById('breakfast-btn');
    const lunchBtn = document.getElementById('lunch-btn');
    const dinnerBtn = document.getElementById('dinner-btn');

    const breakfastMenu = document.getElementById('breakfast-menu');
    const lunchMenu = document.getElementById('lunch-menu');
    const dinnerMenu = document.getElementById('dinner-menu');

    breakfastBtn.addEventListener('click', function() {
        breakfastMenu.classList.add('active');
        lunchMenu.classList.remove('active');
        dinnerMenu.classList.remove('active');
    });

    lunchBtn.addEventListener('click', function() {
        lunchMenu.classList.add('active');
        breakfastMenu.classList.remove('active');
        dinnerMenu.classList.remove('active');
    });

    dinnerBtn.addEventListener('click', function() {
        dinnerMenu.classList.add('active');
        breakfastMenu.classList.remove('active');
        lunchMenu.classList.remove('active');
    });
});


// food ordering form script

// document.getElementById('order-form').addEventListener('submit', function(event) {
//     event.preventDefault(); // Prevent form from submitting normally

//     const name = document.getElementById('name').value;
//     const email = document.getElementById('email').value;
//     const phone = document.getElementById('phone').value;
//     const address = document.getElementById('address').value;
//     const foodSelection = document.getElementById('food-selection').value;
//     const quantity = document.getElementById('quantity').value;
//     const instructions = document.getElementById('instructions').value;

//     // Display order summary (in a real application, you might send this data to a server)
//     alert(`
//         Order Summary:
//         Name: ${name}
//         Email: ${email}
//         Phone: ${phone}
//         Address: ${address}
//         Food: ${foodSelection}
//         Quantity: ${quantity}
//         Instructions: ${instructions}
//     `);

//     // Reset the form
//     document.getElementById('order-form').reset();
// });


// loginpage script

document.addEventListener('DOMContentLoaded', (event) => {
    const modal = document.getElementById('loginModal');
    const loginButton = document.getElementById('loginButton');
    const closeButton = document.querySelector('.close-button');

    loginButton.onclick = function() {
        modal.style.display = "block";
    }

    closeButton.onclick = function() {
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    const loginForm = document.getElementById('loginForm');
    loginForm.onsubmit = function(event) {
        event.preventDefault();
        // Perform login logic here
        alert('Login submitted!');
        modal.style.display = "none";
    }
});


// JavaScript to handle preloader
document.addEventListener("DOMContentLoaded", function() {
    // Function to hide the preloader and show the content
    function hidePreloader() {
        const preloader = document.getElementById("preloader");
        const content = document.getElementById("content");
        preloader.style.display = "none";
        content.style.display = "block";
    }

    // Simulate loading time
    setTimeout(hidePreloader, 2000); // Adjust the time as needed
});


