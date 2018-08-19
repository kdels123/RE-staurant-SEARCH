export class AdminServiceClient {


    findAdminById(adminId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/admin/' + adminId)
            .then(function (response) {
                return response.json();
            });
    }

    createAdmin(username, password) {
        const user = {
            username: username,
            password: password
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/admin', {
            body: JSON.stringify(user),
            credentials: 'same-origin', // include, same-origin, *omit
            method: 'post',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

    updateAdmin(firstName, lastName, email, phone, dob, userId) {
        const user = {
            firstName: firstName,
            lastName: lastName,
            phone: phone,
            email: email,
            dob: dob
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/admin/' + userId, {
            body: JSON.stringify(user),
            method: 'put',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    loginAdmin(username, password) {
        const credentials = {
            username: username,
            password: password
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/admin/login', {
            method: 'post',
            credentials: 'same-origin',
            body: JSON.stringify(credentials),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }

}
