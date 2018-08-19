export class PatronServiceClient {


    findPatronById(patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/' + patronId)
            .then(function (response) {
                return response.json();
            });
    }

    findAllPatrons() {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/')
            .then(function (response) {
                return response.json();
            });
    }

    findPatronByUsername(username) {
        const user = {
            username: username
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/username', {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

    findPatronsByRestaurant(restaurantId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/' + restaurantId + '/patron')
            .then(function (response) {
                return response.json();
            });
    }

    findPatronsByCritic(criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId + '/patron')
            .then(function (response) {
                return response.json();
            });
    }

    findBlockPatronsByCritic(criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId + '/blockpatron')
            .then(function (response) {
                return response.json();
            });
    }

    findPatronsByOwner(ownerId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/patron')
            .then(function (response) {
                return response.json();
            });
    }

    findPatronsByEvent(eventId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/' + eventId + '/patron')
            .then(function (response) {
                return response.json();
            });
    }

    findPatronInvitesByOwner(ownerId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/patronInvite')
            .then(function (response) {
                return response.json();
            });
    }


    findFavoriteCritic(patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/favoriteCritic/' + patronId + '/patron')
            .then(function (response) {
                return response.json();
            });
    }

    createPatron(username, password) {
        const user = {
            username: username,
            password: password
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron', {
            body: JSON.stringify(user),
            credentials: 'same-origin', // include, same-origin, *omit
            method: 'post',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

    updatePatron(firstName, lastName, email, phone, dob, userId) {
        const user = {
            firstName: firstName,
            lastName: lastName,
            phone: phone,
            email: email,
            dob: dob
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/' + userId, {
            body: JSON.stringify(user),
            method: 'put',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    restaurantToPatron(patronId, restaurantId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/' + restaurantId + '/patron/' + patronId);
    }

    criticToPatron(patronId, criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId + '/patron/' + patronId);
    }

    addOwnerToPatronEndorsed(ownerId, patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/patron/' + patronId);
    }

    addEventToPatron(eventId, patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/' + eventId + '/patron/' + patronId);
    }

    addFavoriteCritic(criticId, patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/favoriteCritic/' + criticId + '/patron/' + patronId);
    }

    deletePatron(patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/' + patronId, {
            method: 'delete'
        });
    }

    loginPatron(username, password) {
        const credentials = {
            username: username,
            password: password
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/login', {
            method: 'post',
            credentials: 'same-origin',
            body: JSON.stringify(credentials),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }


}
