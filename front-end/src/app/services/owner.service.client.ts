export class OwnerServiceClient {


    findOwnerById(ownerId) {
        return fetch('http://localhost:8080/api/owner/' + ownerId)
            .then(response => response.json());
    }

    findAllOwners() {
        return fetch('http://localhost:8080/api/owner/')
            .then(function (response) {
                return response.json();
            });
    }

    findOwnerByUsername(username) {
        const user = {
            username: username
        };
        return fetch('http://localhost:8080/api/owner/username', {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
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

    deleteOwner(ownerId) {
        return fetch('http://localhost:8080/api/owner/' + ownerId, {
            method: 'delete'
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