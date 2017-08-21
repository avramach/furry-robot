import React from 'react';

class Comments extends React.Component {
    constructor() {
        super();
        // TODO: the comments shall come in from the input
        // TODO: set the delete button depending on input authorization code
        this.state = {
            commentlist: [
                {
                    commentId: 1,
                    content: "This is a nice blog.",
                    userName: "GuruVinayak P",
                    timeStamp: "Now",
                    upvotes: 1,
                    downvotes: 0
                }
            ]
        };
        this.renderComment = this.renderComment.bind(this);
    }

    renderComment(comment, index) {
        return (
            <div key={index} className="row">
                <div className="col-md-2"></div>
                <div className="col-md-8">
                    <div className="w3-card-4">
                        <div className="w3-container text-justify">
                            <h6>Posted by <i><b>{comment.userName}</b></i> on <i>{comment.timeStamp}</i></h6>
                            {comment.content}
                        </div>

                        <footer className="w3-container w3-light-gray">
                            <div className="row">
                                <div className="col-md-6">
                                    <button type="button" className="w3-btn w3-block w3-light-gray w3-hover-blue btn-default" id="appCommentsDelete{index}">Delete</button>
                                </div>
                                <div className="col-md-2"></div>
                                <div className="col-md-2">
                                    <button type="button" className="w3-btn w3-block w3-light-gray w3-hover-blue"><span className="glyphicon glyphicon-thumbs-up"></span> <span className="badge">{comment.upvotes}</span></button>
                                </div>
                                <div className="col-md-2">
                                    <button type="button" className="w3-btn w3-block w3-light-gray w3-hover-blue"><span className="glyphicon glyphicon-thumbs-down"></span> <span className="badge">{comment.downvotes}</span></button>
                                </div>
                            </div>
                        </footer>
                    </div>
                </div>
                <div className="col-md-2"></div>
                <div className="w3-panel w3-white"></div>
            </div>
        );
    }

    render() {
        return (
            <div id="appComments">
                {this.state.commentlist.map((comment, index) => this.renderComment(comment, index))}
            </div>
        );
    }
}

export default Comments;