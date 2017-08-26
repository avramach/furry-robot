import React from 'react';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

class CreateComment extends React.Component {
    render() {
        return (
            <div id="appCreateComment" className="container-fluid text-center">
                <div className="row content">
                    <div className="col-sm-2"></div>
                    <div className="col-sm-8 text-center w3-left-align">
                        <label htmlFor="appCreateCommentContent">Comment:</label>
                        <textarea className="form-control" rows="5" id="appCreateCommentContent"></textarea>
                        <div className="form-group"></div>
                        <div className="col-md-6">
                            <button type="button" className="w3-btn w3-block w3-black w3-hover-blue btn-default" id="appCreateCommentPost">Post</button>
                        </div>
                        <div className="col-md-6">
                            <Link to="/"><button type="button" className="w3-btn w3-block w3-black w3-hover-blue btn-default" id="appCreateCommentCancel">Cancel</button></Link>
                        </div>
                    </div>
                    <div className="col-sm-2"></div>
                </div>
            </div>
        );
    }
}

export default CreateComment;