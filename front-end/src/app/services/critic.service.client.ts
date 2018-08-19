export class CriticServiceClient {


    findCriticById(criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId)
            .then(function (response) {
                return response.json();
            });
    }

    findAllCritics() {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/')
            .then(function (response) {
                return response.json();
            });
    }

    findCriticByReview(reviewId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/review/' + reviewId + '/critic')
            .then(function (response) {
                return response.json();
            });
    }

    findCriticsByPatron(patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/' + patronId + '/critic')
            .then(function (response) {
                return response.json();
            });
    }

    findCriticsByOwner(ownerId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/critic')
            .then(function (response) {
                return response.json();
            });
    }

    findCriticsByEvent(eventId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/' + eventId + '/critic')
            .then(function (response) { return response.json();
            });
    }

    findCriticInvitesByOwner(ownerId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/criticInvite')
            .then(function (response) {
                return response.json();
            });
    }

    addBlockPatron(patronId, criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/' + patronId + '/critic/' + criticId);
    }

    addOwnerToCriticEndorsed(ownerId, criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/critic/' + criticId);
    }

    addEventToCritic(eventId, criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/' + eventId + '/critic/' + criticId);
    }

    findCriticByUsername(username) {
        const user = {
            username: username
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/username', {
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
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic', {
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
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + userId, {
            body: JSON.stringify(user),
            method: 'put',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    deleteCritic(criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId, {
            method: 'delete'
        });
    }

    loginCritic(username, password) {
        const credentials = {
            username: username,
            password: password
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/login', {
            method: 'post',
            credentials: 'same-origin',
            body: JSON.stringify(credentials),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }


}
