const getFactors = (num) => {
    let result = "";
    
    for (let i = 1; i < num; i++) {
        if (num % i === 0) {
            result += i + " ";
        }
    }
    
    return result.trim();
};

console.log(getFactors(6));