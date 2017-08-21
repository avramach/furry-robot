import React from 'react';

class Blog extends React.Component {
    constructor() {
        super();
        // TODO: the blog shall come in from the input
        // TODO: set the delete button depending on input authorization code
        this.state = {
            blog: {
                blogId: 1,
                title: "This is my first blog",
                content: "This is a new blog.",
                userName: "GuruVinayak P",
                timeStamp: "Now",
                comments: 1,
                upvotes: 1,
                downvotes: 0
            }
        };
        this.renderBlog = this.renderBlog.bind(this);
    }

    renderBlog(blog) {
        return (
            <div className="row">
                <div className="col-md-2"></div>
                <div className="col-md-8">
                    <div className="w3-card-4">
                        <header className="w3-container w3-gray text-center">
                            <h1><b>{blog.title}</b></h1>
                            <h6>Posted by <i><b>{blog.userName}</b></i> on <i>{blog.timeStamp}</i></h6>
                        </header>

                        <div className="w3-container text-justify blog-content">
                            {blog.content}
                        </div>

                        <footer className="w3-container w3-light-gray">
                            <div className="row">
                                <div className="col-md-6">
                                    <button type="button" className="w3-btn w3-block w3-light-gray w3-hover-blue btn-default" id="appBlogsDelete{index}">Delete</button>
                                </div>
                                <div className="col-md-2">
                                    <button type="button" className="w3-button w3-block w3-light-gray w3-hover-light-gray">Comments <span className="badge">{blog.comments}</span></button>
                                </div>
                                <div className="col-md-2">
                                    <button type="button" className="w3-btn w3-block w3-light-gray w3-hover-blue"><span className="glyphicon glyphicon-thumbs-up"></span> <span className="badge">{blog.upvotes}</span></button>
                                </div>
                                <div className="col-md-2">
                                    <button type="button" className="w3-btn w3-block w3-light-gray w3-hover-blue"><span className="glyphicon glyphicon-thumbs-down"></span> <span className="badge">{blog.downvotes}</span></button>
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
            <div id="appBlog">
                {this.renderBlog(this.state.blog)}
            </div>
        );
    }
}

export default Blog;