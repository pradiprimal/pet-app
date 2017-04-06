<%-- 
    Document   : login
    Created on : Mar 16, 2017, 12:37:22 PM
    Author     : admin
--%>
<style>
    form {
        border: 3px solid #f1f1f1;
    }

    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    button:hover {
        opacity: 0.8;
    }

    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }

    .imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
    }

    img.avatar {
        width: 40%;
        border-radius: 50%;
    }

    .container {
        padding: 16px;
    }

    span.psw {
        float: right;
        padding-top: 16px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }
        .cancelbtn {
            width: 100%;
        }
    }
</style>
<!--<pre>{{loginData|json}}</pre>-->

<form name="login" novalidate="true" ng-submit="authenticate()"  ng-hide="isLoggedIn">
    <div>
        <span ng-show="errorMessage.lenght !== 0" style="color: red;padding-left: 600px;">{{errorMessage}}</span>
    </div>
    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required ng-model="loginData.userName" ng-minlength="3" ng-maxlength="30">
        <!--        <div ng-if="login.uname.$dirty">
                    <span ng-show="login.uname.$error.required">This field is required.</span>
                    <span ng-show="login.uname.$error.minlength">Username is too short.</span>
                    <span ng-show="login.uname.$error.maxlength">Username is too long.</span>
                </div>-->
        <div ng-messages="login.uname.$error" ng-if="login.uname.$dirty">
            <div ng-message="required">This field is required.</div>
            <div ng-message="minlength">Username is too short.</div>
            <div ng-message="maxlength">Username is too long.</div>
        </div>
        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required ng-model="loginData.password">

        <button type="submit" ng-disabled="login.$invalid">Login</button>
    </div>
</form>