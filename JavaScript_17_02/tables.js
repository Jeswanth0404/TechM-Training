const multiplicationTable = () => {
    let number = parseInt(prompt("Enter the number:"));
    let limit = parseInt(prompt("Enter the limit:"));

    for (let i = 1; i <= limit; i++) {
        console.log(`${number} * ${i} = ${number * i}`);
    }
};

multiplicationTable();
