import React from 'react';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

import Header from './src/components/Header.jsx';
import Blogs from './src/components/Blogs.jsx';
import Banner from './src/components/Banner.jsx';
import Login from './src/components/Login.jsx';
import Blog from './src/components/Blog.jsx';
import Comments from './src/components/Comments.jsx';

class Apps extends React.Component {
    constructor(props) {
        super();
        this.state = {
            page: props.page
        };
        this.BlogsPage = this.BlogsPage.bind(this);
        this.LoginPage = this.LoginPage.bind(this);
        this.BlogWithComments = this.BlogWithComments.bind(this);
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

    BlogWithComments() {
        return (
            <div>
                < Header login = { true } />
                < Banner />
                < Blog />
                < Comments />
            </div>
        );
    }

    render() {
        return (
            <Router>
                <div>
                    <Route exact path="/" component={this.BlogsPage}/>
                    <Route path="/login" component={this.LoginPage}/>
                    <Route path="/blog/:blogId" component={this.BlogWithComments}/>
                </div>
            </Router>
        );
    }
}

export default Apps;