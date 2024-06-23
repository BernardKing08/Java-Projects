// scripts.js

// Sample script to handle adding items to the cart and other interactivity

document.addEventListener('DOMContentLoaded', function () {
    const addToCartButtons = document.querySelectorAll('#add-to-cart');

    addToCartButtons.forEach(button => {
        button.addEventListener('click', function () {
            // Add to cart functionality
            alert('Book added to cart!');
        });
    });

    const checkoutButton = document.getElementById('checkout');
    if (checkoutButton) {
        checkoutButton.addEventListener('click', function () {
            // Checkout functionality
            alert('Proceeding to checkout!');
        });
    }
});
