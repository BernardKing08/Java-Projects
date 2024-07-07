// scripts.js
const bootstrapScript = document.createElement('script');
bootstrapScript.src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js";
bootstrapScript.integrity = "sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz";
bootstrapScript.crossOrigin = "anonymous";
document.head.appendChild(bootstrapScript);
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
