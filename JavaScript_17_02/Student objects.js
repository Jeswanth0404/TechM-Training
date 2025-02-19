const student = {
    id: 276,
    name: "SUD",
    department: "Maths",
    college: "PEC",
    email: "Jessu@gmail.com",
    displayDetails: function() {
        console.log(`ID: ${this.id}`);
        console.log(`Name: ${this.name}`);
        console.log(`Department: ${this.department}`);
        console.log(`College: ${this.college}`);
        console.log(`Email: ${this.email}`);
    },
    address: {
        doorNo: 4,
        street: "Ashok Nagar",
        area: "LeelaMahal",
        pincode: 517504
    },
    displayFullDetails: function() {
        this.displayDetails();
        console.log(`Door No: ${this.address.doorNo}`);
        console.log(`Street: ${this.address.street}`);
        console.log(`Area: ${this.address.area}`);
        console.log(`Pincode: ${this.address.pincode}`);
    }
};

student.displayDetails();

student.displayBasicInfo = function() {
    console.log(`ID: ${this.id}`);
    console.log(`Name: ${this.name}`);
    console.log(`Email: ${this.email}`);
};

student.displayBasicInfo();
student.displayFullDetails();
