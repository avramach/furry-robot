import React from 'react';

class Login extends React.Component {
    render() {
        return (
            <div id="appLogin" className="container-fluid text-center">
                <div className="row content">
                    <div className="col-sm-3"></div>
                    <div className="col-sm-6 text-center">
                        <form className="w3-container">
                            <div className="form-group"></div>
                            <div className="form-group">
                                <input type="text" className="w3-input w3-border w3-block" id="appLoginUserName" placeholder="User Name " />
                            </div>
                            <div className="form-group">
                                <input type="password " className="w3-input w3-border w3-block" id="appLoginPassword" placeholder="Password " />
                            </div>
                            <div className="form-group">
                                <div className="col-md-6">
                                    <button type="button" className="w3-btn w3-block w3-black w3-hover-blue btn-default" id="appLoginLogin">Login</button>
                                </div>
                                <div className="col-md-6">
                                    <button type="button" className="w3-btn w3-block w3-black w3-hover-blue btn-default" id="appLoginSignup">Signup</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div className="col-sm-3"></div>
                </div>
            </div>
        );
    }
}

export default Login;