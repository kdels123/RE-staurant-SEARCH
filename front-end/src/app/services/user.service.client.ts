export class UserServiceClient {

    createAdmin(username, password) {
        const user = {
            username: username,
            password: password
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/admin', {
            body: JSON.stringify(user),
            credentials: 'include', // include, same-origin, *omit
            method: 'post',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json());
    }


}
