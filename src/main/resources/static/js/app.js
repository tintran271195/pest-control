class App {
    static BASE_URL_CATEGORY = "http://localhost:8080/v1/category";
    static BASE_URL_CONTRACT = "http://localhost:8080/v1/contract";
    static BASE_URL_CUSTOMER = "http://localhost:8080/v1/customer";
    static BASE_URL_PRODUCT = "http://localhost:8080/v1/product";
    static BASE_URL_REPORT = "http://localhost:8080/v1/report";
    static BASE_URL_STAFF = "http://localhost:8080/v1/staff";
    static BASE_URL_STATION = "http://localhost:8080/v1/station";

    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: 'warning',
            text: 'Are you sure you want to delete the selected data ?',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it !',
            cancelButtonText: 'Cancel',
        })
    }

    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }
}

class Category {
    constructor(id, name, products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }
}

class Contract {
    constructor(id, numberOfContract, customer, station, reports, isEnabled, isDelete) {
        this.id = id;
        this.numberOfContract = numberOfContract;
        this.customer = customer;
        this.station = station;
        this.reports = reports;
        this.isEnabled = isEnabled;
        this.isDelete = isDelete;
    }
}

class Customer {
    constructor(id, fullName, address, phoneNumber, email, contracts) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.contracts = contracts;
    }
}

class Product {
    constructor(id, name, price, category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

class Report {
    constructor(id, staff, contract, reportDate) {
        this.id = id;
        this.staff = staff;
        this.contract = contract;
        this.reportDate = reportDate;
    }
}

class Station {
    constructor(id, name, staffs) {
        this.id = id;
        this.name = name;
        this.staffs = staffs;
    }
}

class Staff {
    constructor(id, fullName, phone, identityCard, dob, email, address, station) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.identityCard = identityCard;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.station = station;
    }
}
