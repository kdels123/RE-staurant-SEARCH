export class CriticServiceClient {


    findCriticById(criticId) {
        return fetch('http://localhost:8080/api/critic/' + criticId)
            .then(function (response) {
                return response.json();
            });
    }

    findCriticByReview(reviewId) {
        return fetch('http://localhost:8080/api/review/' + reviewId + '/critic')
            .then(function (response) { return response.json();
            });
    }

    findCriticByUsername(username) {
        const user = {
            username: username
        };
        return fetch('http://localhost:8080/api/critic/username', {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

    createCritic(username, password) {
        const user = {
            username: username,
            password: password
        };
        return fetch('http://localhost:8080/api/critic', {
            body: JSON.stringify(user),
            credentials: 'same-origin', // include, same-origin, *omit
            method: 'post',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

    updateCritic(firstName, lastName, email, phone, dob, userId) {
        const user = {
            firstName: firstName,
            lastName: lastName,
            phone: phone,
            email: email,
            dob: dob
        };
        return fetch('http://localhost:8080/api/critic/' + userId, {
            body: JSON.stringify(user),
            method: 'put',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    loginCritic(username, password) {
        const credentials = {
            username: username,
            password: password
        };
        return fetch('http://localhost:8080/api/critic/login', {
            method: 'post',
            credentials: 'same-origin',
            body: JSON.stringify(credentials),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

}