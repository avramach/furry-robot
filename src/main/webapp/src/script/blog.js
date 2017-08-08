var URLBase = "http://192.168.99.100:9999/cmad-blog-project/";

function createComment(id) {
    var commentTemplate = '<div class="panel panel-default"> \
                                <div class="panel-body"> \
                                    <span id="comment-{0}-content"></span> \
                                </div> \
                                <div class="panel-footer row"> \
                                    <div class="col-md-6"> \
                                    </div> \
                                    <div class="col-md-2"> \
                                    </div> \
                                    <div class="col-md-2"> \
                                        <a href="#"><span class="glyphicon glyphicon-thumbs-up"></span> <span class="badge" id="comment-{0}-upvotes"></span></a> \
                                    </div> \
                                    <div class="col-md-2"> \
                                        <a href="#"><span class="glyphicon glyphicon-thumbs-down"></span> <span class="badge" id="comment-{0}-downvotes"></span></a> \
                                    </div> \
                                </div> \
                            </div>'

    var comment = commentTemplate.replace(/\{0\}/g, id);
    return comment;
}

function createBlog() {
    var blogTemplate = '<h2><b><span id="blog-0-title"></span></b></h2> \
                        <div class="panel panel-default"> \
                            <div class="panel-body"> \
                                <span id="blog-0-content"></span> \
                            </div> \
                            <div class="panel-footer row"> \
                                <div class="col-md-6"> \
                                    <a href="#">#delete</a> \
                                </div> \
                                <div class="col-md-2"> \
                                    <a href="#">Comments <span class="badge" id="blog-0-comments"></span></a> \
                                </div> \
                                <div class="col-md-2"> \
                                    <a href="#"><span class="glyphicon glyphicon-thumbs-up"></span> <span class="badge" id="blog-0-upvotes"></span></a> \
                                </div> \
                                <div class="col-md-2"> \
                                    <a href="#"><span class="glyphicon glyphicon-thumbs-down"></span> <span class="badge" id="blog-0-downvotes"></span></a> \
                                </div> \
                            </div> \
                        </div>'

    return blogTemplate;
}

function appendBlog(id, focus) {
    var blogTemplate = '<div class="panel panel-default"> \
                    <div class="panel-heading"> \
                        <h4 class="panel-title"> \
                            <a data-toggle="collapse" data-parent="#{1}" href="#collapse{0}"> \
                                <span id="blog-{0}-title"></span> \
                            </a> \
                        </h4> \
                    </div> \
                    <div id="collapse{0}" class="panel-collapse collapse {2}"> \
                        <div class="panel-body" style="overflow: hidden; height:5em"> \
                            <span id="blog-{0}-content"></span> \
                        </div> \
                        <div class="panel-footer row"> \
                            <div class="col-md-6"> \
                                <a href="#">#delete</a> \
                            </div> \
                            <div class="col-md-2"> \
                                <a href="#">Comments <span class="badge" id="blog-{0}-comments"></span></a> \
                            </div> \
                            <div class="col-md-2"> \
                                <a href="#"><span class="glyphicon glyphicon-thumbs-up"></span> <span class="badge" id="blog-{0}-upvotes"></span></a> \
                            </div> \
                            <div class="col-md-2"> \
                                <a href="#"><span class="glyphicon glyphicon-thumbs-down"></span> <span class="badge" id="blog-{0}-downvotes"></span></a> \
                            </div> \
                        </div> \
                    </div> \
                </div>';

    console.log("appendBlog: " + id + "/ " + focus);
    var collapse = (focus === true) ? "in" : "";
    var blog = blogTemplate.replace(/\{0\}/g, id).replace(/\{1\}/g, "bloglist").replace(/\{2\}/g, collapse);
    console.log("blog: " + blog);
    return blog;
}

function loadHomePage() {
    // send a request to load all the blog entries
    var url = URLBase + "public/blogs";
    var blog = "";

    // allow option to create and sort tabs
    $('#opt-create').show();
    $('#opt-sort').show();

    $('#blog-list').show();
    $('#blog-read').hide();

    $.getJSON(url, function(bloglist) {
        console.warn("Blog: " + bloglist);
        $.each(bloglist, function(index, blogEntry) {
            blog = blog.concat(appendBlog(index, (index === 0) ? true : false));
        })

        $("#bloglist").html(blog);

        $.each(bloglist, function(index, blogEntry) {
            console.warn("Index: " + index + " blogEntry: " + JSON.stringify(blogEntry));
            $("#blog-" + index + "-title").html(blogEntry.title);
            $("#blog-" + index + "-content").html(blogEntry.blogContent);
            //$("#blog-" + index + "-comments").html(0);
            $("#blog-" + index + "-upvotes").html(blogEntry.upVote);
            $("#blog-" + index + "-downvotes").html(blogEntry.downVote);
        })
    })
}

function loadBlog(blogId) {
    // send a request to load the input blog entry
    var url = URLBase + "public/blogs/" + blogId;

    // allow option to sort tabs/ hide create option
    $('#opt-create').hide();
    $('#opt-sort').show();

    $('#blog-list').hide();
    $('#blog-read').show();

    $.getJSON(url, function(blog) {
        $("#blogread").html("".concat(createBlog()));
        $("#blog-" + index + "-title").html(blogEntry.title);
        $("#blog-" + index + "-content").html(blogEntry.blogContent);
        //$("#blog-" + index + "-comments").html(0);
        $("#blog-" + index + "-upvotes").html(blogEntry.upVote);
        $("#blog-" + index + "-downvotes").html(blogEntry.downVote);
    });
}

$(document).ready(function() {
    loadHomePage();
    // //var url = "http://localhost:8081/cmad-blog-project/public/blogs"
    // var blog1 = appendBlog("1", true);
    // var blog2 = appendBlog("2");

    // $("#bloglist").html("".concat(blog1).concat(blog2));

    // $('#opt-create').show();
    // $('#opt-sort').show();

    // //$("#blogread").html("".concat(createBlog()));
    // //$("#commentlist").html("".concat(createComment("1").concat(createComment("2")).concat(createComment("3"))));

    // $("#blog-1-title").html("First Blog...");
    // $("#blog-1-content").html("This is my first blog!!!<br>This<br>is<br>my<br>first<br>blog!!!\n");
    // $("#blog-1-comments").html("0");
    // $("#blog-1-upvotes").html("0");
    // $("#blog-1-downvotes").html("0");

    // // $("#comment-1-content").html("This is blah blah!!!\n");
    // // $("#comment-1-upvotes").html("0");
    // // $("#comment-1-downvotes").html("0");

    // // $("#comment-2-content").html("This is blah blah 2!!!\n");
    // // $("#comment-2-upvotes").html("0");
    // // $("#comment-2-downvotes").html("0");

    // // $("#comment-3-content").html("This is blah blah 3!!!\n");
    // // $("#comment-3-upvotes").html("0");
    // // $("#comment-3-downvotes").html("0");

    // $("#blog-2-title").html("Second Blog...");
    // $("#blog-2-content").html("This is my second blog!!!");
    // $("#blog-2-comments").html("0");
    // $("#blog-2-upvotes").html("0");
    // $("#blog-2-downvotes").html("0");


});