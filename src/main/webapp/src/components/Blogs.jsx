import React from 'react';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

class Blogs extends React.Component {
    constructor() {
        super();
        // TODO: the blog list shall come in from the input
        // TODO: set the delete button depending on input authorization code
        this.state = {
            bloglist: [
                {
                    blogId: 1,
                    title: "This is my first blog",
                    content: "This is a new blog.",
                    userName: "GuruVinayak P",
                    timeStamp: "Now",
                    comments: 1,
                    upvotes: 1,
                    downvotes: 0
                },
                {
                    blogId: 2,
                    title: "This is my second blog",
                    content: "This is as well a  new blog.",
                    userName: "GuruVinayak P",
                    timeStamp: "Now",
                    comments: 1,
                    upvotes: 1,
                    downvotes: 0
                }
            ]
        };
        this.renderBlog = this.renderBlog.bind(this);
    }

    renderBlog(blog, index) {
        return (
            <div key={index} className="row">
                <div className="col-md-2"></div>
                <div className="col-md-8">
                    <div className="w3-card-4">
                        <header className="w3-container w3-gray text-center">
                            <h1><b>{blog.title}</b></h1>
                            <h6>Posted by <i><b>{blog.userName}</b></i> on <i>{blog.timeStamp}</i></h6>
                        </header>

                        <Link to="/blog/{blog.blogId}">
                        <div className="w3-container text-justify blogs-content">
                            {blog.content}
                        </div>
                        </Link>

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
            <div id="appBlogs">
                {this.state.bloglist.map((blog, index) => this.renderBlog(blog, index))}
            </div>
        );
    }
}

export default Blogs;