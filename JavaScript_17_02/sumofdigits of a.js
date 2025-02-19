const sumOfDigits = (num) => {
    let sum = 0;
    
    while (num > 0) {
        sum += num % 10;
        num = Math.floor(num / 10);
    }
    if(sum % 2 == 0){
        return "even";
    }
    else{
        return "Odd";
    }
};

console.log(sumOfDigits(1234));
