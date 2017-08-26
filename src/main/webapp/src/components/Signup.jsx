import React from 'react';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

class Signup extends React.Component {
    render() {
        return (
            <div id="appSignup" className="container-fluid text-center">
                <div className="row content">
                    <div className="col-sm-3"></div>
                    <div className="col-sm-6 text-center">
                        <form className="w3-container">
                            <div className="form-group"></div>
                            <div className="form-group col-md-12">
                                <input type="text" className="w3-input w3-border w3-block" id="appSignupFirstName" placeholder="First Name " />
                            </div>
                            <div className="form-group col-md-12">
                                <input type="text" className="w3-input w3-border w3-block" id="appSignupLastName" placeholder="Last Name " />
                            </div>
                            <div className="form-group col-md-12">
                                <input type="text" className="w3-input w3-border w3-block" id="appSignupEMail" placeholder="EMail " />
                            </div>
                            <div className="form-group col-md-12">
                                <input type="text" className="w3-input w3-border w3-block" id="appSignupUserName" placeholder="User Name " />
                            </div>
                            <div className="form-group col-md-12">
                                <input type="password " className="w3-input w3-border w3-block" id="appSignupPassword" placeholder="Password " />
                            </div>
                            <div className="form-group">
                                <div className="col-md-6">
                                    <button type="button" className="w3-btn w3-block w3-black w3-hover-blue btn-default" id="appSignupCreate">Create</button>
                                </div>
                                <div className="col-md-6">
                                    <Link to="/"><button type="button" className="w3-btn w3-block w3-black w3-hover-blue btn-default" id="appSignupLogin">Cancel</button></Link>
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

export default Signup;