export class OwnerServiceClient {


    findOwnerById(ownerId) {
        return fetch('http://localhost:8080/api/owner/' + ownerId)
            .then(response => response.json());
    }


    createOwner(username, password) {
        const user = {
            username: username,
            password: password
        };
        return fetch('http://localhost:8080/api/owner', {
            body: JSON.stringify(user),
            method: 'post',
            credentials: 'same-origin',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => {
            return response.json();
        });
    }

    updateOwner(firstName, lastName, email, phone, dob, userId) {
        const user = {
            firstName: firstName,
            lastName: lastName,
            phone: phone,
            email: email,
            dob: dob
        };
        return fetch('http://localhost:8080/api/owner/' + userId, {
            body: JSON.stringify(user),
            method: 'put',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    loginOwner(username, password) {
        const credentials = {
            username: username,
            password: password
        };
        return fetch('http://localhost:8080/api/owner/login', {
            method: 'post',
            credentials: 'same-origin',
            body: JSON.stringify(credentials),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

}