export class UserServiceClient {

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


}
