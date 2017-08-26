import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from 'react-router-dom';

import Header from './src/components/Header.jsx';
import Blogs from './src/components/Blogs.jsx';
import Banner from './src/components/Banner.jsx';
import Login from './src/components/Login.jsx';
import Signup from './src/components/Signup.jsx';
import Blog from './src/components/Blog.jsx';
import Comments from './src/components/Comments.jsx';
import CreateBlog from './src/components/CreateBlog.jsx';
import CreateComment from './src/components/CreateComment.jsx';

class Apps extends React.Component {
    constructor(props) {
        super();
        this.SignupPage = this.SignupPage.bind(this);
        this.BlogsPage = this.BlogsPage.bind(this);
        this.LoginPage = this.LoginPage.bind(this);
        this.BlogWithComments = this.BlogWithComments.bind(this);
        this.CreateBlogPage = this.CreateBlogPage.bind(this);
    }

    BlogsPage() {
        return (
            <div>
                < Header login = { true } />
                < Banner />
                < Blogs />
            </div>
        );
    }

    LoginPage() {
        return (
            <div>
                < Header login = { true } />
                < Banner />
                < Login />
            </div>
        );
    }

    SignupPage() {
        return (
            <div>
                < Header login = { true } />
                < Banner />
                < Signup />
            </div>
        );
    }

    BlogWithComments() {
        return (
            <div>
                < Header login = { true } />
                < Banner />
                < Blog />
                < Comments />
                < CreateComment />
            </div>
        );
    }

    CreateBlogPage() {
        return (
            <div>
                < Header login = { true } />
                < Banner />
                < CreateBlog />
            </div>
        );        
    }

    render() {
        return (
            <Router>
                <Switch>
                    <Route exact path="/login" component={this.LoginPage}/>
                    <Route exact path="/signup" component={this.SignupPage}/>
                    <Route exact path="/create" component={this.CreateBlogPage}/>
                    <Route exact path="/blog" component={this.BlogWithComments}/>
                    <Route exact path="/blogs" component={this.BlogsPage}/>
                    <Route exact path="/" component={this.BlogsPage}/>
               </Switch>
            </Router>
        );
    }
}

export default Apps;