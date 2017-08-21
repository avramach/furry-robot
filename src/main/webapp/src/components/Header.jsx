import React from 'react';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

class Header extends React.Component {
    constructor(props) {
        super();
        this.state = {
            login: props.login
        };
        this.renderButton = this.renderButton.bind(this);
    }

    renderButton() {
        if (this.state.login) {
            return (
                <Link to="/login"><button type="button" className="w3-btn w3-block w3-black w3-hover-blue btn-default" id="appHeaderLogin">Login</button></Link>
            );
        }
        else {
            return (
                <Link to="/"><button type="button" className="w3-btn w3-block w3-black w3-hover-blue btn-default" id="appHeaderLogout">Logout</button></Link>
            );            
        }
    }

    render() {
        return (
            <div id="appHeader" className="row">
                <div className="form-group">
                    <div className="col-md-6">
                        <img id="appHeaderLogo" src="src/images/logo.png" alt="Cinque Terre">
                        </img>
                    </div>
                    <div className="col-md-4">
                        <input type="text" className="w3-input w3-border w3-block" id="appHeaderCategory" placeholder="Search " />
                    </div>
                    <div className="col-md-2">
                        {this.renderButton()}
                    </div>
                </div>
            </div>
        );
    }
}

export default Header;