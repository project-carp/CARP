export class User{
    userName: string;
    password: string;

    constructor(email, password){
        this.userName = email;
        this.password = password;
    }
}