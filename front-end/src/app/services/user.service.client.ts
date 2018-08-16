export class UserServiceClient {

    createPatron(username, password) {
        const user = {
            username: username,
            password: password
        };
        return fetch('http://localhost:8080/api/patron', {
            body: JSON.stringify(user),
            credentials: 'include', // include, same-origin, *omit
            method: 'post',
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
                'Accept': 'application/json',
                'content-type': 'application/json'
            }
        }).then(response => {
            return response.json();
        });
    }

    createCritic(username, password) {
        const user = {
            username: username,
            password: password
        };
        return fetch('http://localhost:8080/api/critic', {
            body: JSON.stringify(user),
            credentials: 'include', // include, same-origin, *omit
            method: 'post',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

    createAdmin(username, password) {
        const user = {
            username: username,
            password: password
        };
        return fetch('http://localhost:8080/api/admin', {
            body: JSON.stringify(user),
            credentials: 'include', // include, same-origin, *omit
            method: 'post',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
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

    findUserById(userId) {
        return fetch('http://localhost:8080/api/owner/' + userId).then(response => response.json());
    }

    updateUser(firstName, lastName, phone, email, dob, userId) {
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

}
