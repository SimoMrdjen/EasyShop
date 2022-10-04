import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

export const getAllCustomers = () =>
    fetch("customers") //ovo je url API-a, prvi deo je definisan u proxy-u
        .then(checkStatus);

 export const addNewCustomer = customer =>
     fetch("customers", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(customer)
            }
         );

 export const deleteCustomer = customerId =>
     fetch(`customers/${customerId}`, {method: 'DELETE'})
            .then(checkStatus);

 export const editCustomer = customer =>
     fetch("customers", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'PUT',
            body: JSON.stringify(customer)
            }
         );