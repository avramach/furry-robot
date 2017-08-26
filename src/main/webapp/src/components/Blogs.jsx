import React from 'react';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

import * as Backend from '../script/backend.js';

class Blogs extends React.Component {
    constructor() {
        super();
        // TODO: set the delete button depending on input authorization code
        this.state = {
            blogs: []
        };
        this.renderBlog = this.renderBlog.bind(this);

        Backend.getBlogs((blogs) => {
            this.setState({
                blogs: blogs
            });
            console.warn(blogs)
        });
    }

    renderBlog(blog, index) {
        return (
            <div key={index} className="row">
                <div className="col-md-2"></div>
                <div className="col-md-8">
                    <div className="w3-card-4">
                        <header className="w3-container w3-gray text-center">
                            <h1><b>{blog.title}</b></h1>
                            <h6>Posted by <i><b>{blog.author}</b></i> on <i>{Date(blog.lastUpdatedOn)}</i></h6>
                        </header>

                        <Link to={`/blog?blogId=${blog.blogId}`}>
                        <div className="w3-container text-justify blogs-content">
                            {blog.blogContent}
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
                                    <button type="button" className="w3-btn w3-block w3-light-gray w3-hover-blue"><span className="glyphicon glyphicon-thumbs-up"></span> <span className="badge">{blog.upVote}</span></button>
                                </div>
                                <div className="col-md-2">
                                    <button type="button" className="w3-btn w3-block w3-light-gray w3-hover-blue"><span className="glyphicon glyphicon-thumbs-down"></span> <span className="badge">{blog.downVote}</span></button>
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
                {this.state.blogs.map((blog, index) => this.renderBlog(blog, index))}
            </div>
        );
    }
}

export default Blogs;