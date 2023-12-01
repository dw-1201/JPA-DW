let quantity = 1; 
let price = 33000; 

function changeQuantity(amount) {
    quantity += amount;

    if (quantity < 1) {
        quantity = 1;
    }

    document.getElementById('number').innerText = quantity;

    updatePrice();
}

function updatePrice() {
    price = quantity * 33000; 

    const formattedPrice = price.toLocaleString();

    document.getElementById('price').innerText = formattedPrice  + ' 원';
}

// 
function updateTotalPrice() {
    const priceElements = document.querySelectorAll('.item-price');

    let totalPrice = 0;
    priceElements.forEach(element => {
        const price = parseInt(element.getAttribute('data-price'));
        
        totalPrice += price;
    });

    const formattedTotalPrice = totalPrice.toLocaleString();

    document.getElementById('total').innerText = formattedTotalPrice + ' 원';
}

updateTotalPrice();

