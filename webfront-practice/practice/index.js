const host = "http://133.186.241.167:8100";

const loginForm = document.getElementById("login-form");
const cartFrom = document.getElementById("cart-form");
const userId = document.getElementById("userId");
const userPassword = document.getElementById("userPassword");
const table = document.querySelector("#table>tbody");

cartFrom.style.display = "none";

const login = async () => {
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "userId": userId.value,
            "userPassword": userPassword.value
        })
    }

    var response = await fetch(host + "/api/users/login", options);

    if (response.status != 200) {
        return;
    }

    let cartId;
    await response.json().then((json) => {
        document.getElementById("id").innerText += json.userId;
        document.getElementById("name").innerText += json.userName;
        cartId = json.cartId;
        document.getElementById("cartid").innerText += cartId;
    });

    var response = await fetch(host + "/api/nhnmart/shopping-cart/" + cartId, {
        headers: { "X-USER-ID": "nhnacademy" }
    });

    if (response.status != 200) {
        return;
    }

    await response.json().then((json) => {
        let total = 0;
        for (item of json) {
            const tr = document.createElement('tr');
            const productId = document.createElement('td');
            const name = document.createElement('td');
            const price = document.createElement('td');
            const amount = document.createElement('td');
            const totalPrice = document.createElement('td');

            total += item.totalPrice;

            productId.appendChild((document.createTextNode(item.productId)));
            name.appendChild((document.createTextNode(item.name)));
            price.appendChild((document.createTextNode(item.price.toLocaleString() + " 원")));
            amount.appendChild((document.createTextNode(item.amount)));
            totalPrice.appendChild((document.createTextNode(item.totalPrice.toLocaleString() + " 원")));

            tr.appendChild(productId);
            tr.appendChild(name);
            tr.appendChild(price);
            tr.appendChild(amount);
            tr.appendChild(totalPrice);

            table.appendChild(tr);
        }

        const tr = document.createElement('tr');
        const td = document.createElement('td');
        const sum = document.createElement('td');

        td.setAttribute("colspan", "4");

        td.appendChild((document.createTextNode("합계")));
        sum.appendChild((document.createTextNode(total.toLocaleString() + " 원")));

        tr.appendChild(td);
        tr.appendChild(sum);
        table.appendChild(tr);
    })

    loginForm.style.display = "none";
    cartFrom.style.display = "block";
}
