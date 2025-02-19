const calculator = () => {
    let operation = prompt("Enter the operation (add, subtract, product, division):");
    let num1 = parseInt(prompt("Enter the first number:"));
    let num2 = parseInt(prompt("Enter the second number:"));

    switch (operation) {
        case "add":
            console.log(`Sum: ${num1 + num2}`);
            break;
        case "subtract":
            console.log(`Difference: ${num1 - num2}`);
            break;
        case "product":
            console.log(`Product: ${num1 * num2}`);
            break;
        case "division":
            if (num2 !== 0) {
                console.log(`Division: ${num1 / num2}`);
            } else {
                console.log("Error: Division by zero is not allowed.");
            }
            break;
        default:
            console.log("Invalid operation. Please enter add, subtract, product, or division.");
    }
};

calculator();