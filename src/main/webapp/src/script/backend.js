var URLBase = "http://192.168.99.100:8080/cmad-blog-project-advance/";

function getBlogs(callback) {
    var url = URLBase + "public/blogs";

    $.getJSON(url, function(blogs) {
        $.each(blogs, function(index, blog) {
            var countUrl = URLBase + "public/blogs/" + blog.blogId + "/comments/count";
            $.get(countUrl, function(count) {
                blogs[index].comments = count;
            });
        });
        callback(blogs);
    })
}

function getBlog(blogId, callback) {
    var url = URLBase + "public/blogs/" + blogId;

    $.getJSON(url, function(blog) {
        callback(blog);
    })
}

function getComments(blogId, callback) {
    var url = URLBase + "public/blogs/" + blogId + "/comments/";

    $.getJSON(url, function(comments) {
        callback(comments);
    })
}

function authenticateUser(username, password, callback) {
    var url = URLBase + "public/users/authenticateUser";
    var data = {
        userName: username,
        password: password
    };

    $.ajax({
        url: url,
        type: "POST",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        complete: function(jqXHR, textStatus) {
            switch (jqXHR.status) {
                case 200:
                case 201:
                    // TODO: revert - needed since we are testing with CORS
                    // callback(jqXHR.getResponseHeader("Authorization"));
                    callback("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImlzcyI6Imh0dHA6Ly8xOTIuMTY4Ljk5LjEwMDo4MDgwL2NtYWQtYmxvZy1wcm9qZWN0LWFkdmFuY2UvcHVibGljL3VzZXJzL2F1dGhlbnRpY2F0ZVVzZXIiLCJpYXQiOjE1MDM3NDkwNjAsImV4cCI6MTUwMzc1MDI2MH0.KckuIb7NFOW-DwUCKCVB2P4VfzOccEJa4nIrjw3R9eISHoHjOG2wo_Np2a9EYvC_uupU-JYBVoLsuccRX2Qn0Q");
                    break;
                default:
                    callback(null);
                    break;
            }
        }
    });
}
module.exports = {
    getBlogs: getBlogs,
    getBlog: getBlog,
    getComments: getComments,
    authenticateUser: authenticateUser
};