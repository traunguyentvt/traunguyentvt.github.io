$(document).ready(function () {
    // Event handler for "Get User Data" button
    $('#getUserData').on('click', function () {
        const userId = $('#userId').val();
        if (userId) {
            getUserData(userId);
        } else {
            alert('Please enter a valid user ID.');
        }
    });
});

function getUserData(userId) {
    // Get user data from backend
    // $.get(`/userposts?userId=${userId}`, function (user) {
    //     if (user) {
    //         const userInfoHtml = `
    //             <h3>User Info</h3>
    //             <p><strong>Name:</strong> ${user.name}</p>
    //             <p><strong>Email:</strong> ${user.email}</p>
    //             <p><strong>Address:</strong> ${user.address.street}, ${user.address.city}</p>
    //         `;
    //         $('#userInfo').html(userInfoHtml);
    //     } else {
    //         alert('User not found');
    //     }
    // }).fail(function () {
    //     alert('Failed to load user data.');
    // });

    $.ajax("getUserData.ajax", {
        "type": "get",
        "data": {
            "userId": userId
        }
    }).done(function(user) {
        if (user) {
            displayUserInfo(user);
            displayUserPosts(user.posts);
        } else {
            alert('User not found');
        }
    });
}

function getUserPosts(userId) {
    // Get user posts
    $.get(`/userposts?userId=${userId}`, function (posts) {
        displayUserPosts(posts);
    }).fail(function () {
        alert('Failed to load posts.');
    });
}

function displayUserInfo(user) {
    const userInfoHtml = `
                <h3>User Info</h3>
                <p><strong>Name:</strong> ${user.name}</p>
                <p><strong>Email:</strong> ${user.email}</p>
                <p><strong>Address:</strong> ${user.address.street}, ${user.address.city}</p>
            `;
    $('#userInfo').html(userInfoHtml);
}

function displayUserPosts(posts) {
    let postsHtml = '<h3>Posts</h3>';

    posts.forEach(post => {
        postsHtml += `
            <div class="post">
                <h4>${post.title}</h4>
                <p>${post.body}</p>
                <!-- Storing postId in the data-post-id attribute -->
                <button class="toggleComments" data-post-id="${post.id}">Show Comments</button>
                <div class="comments" id="comments-${post.id}" style="display:none;"></div> <!-- Div to show comments -->
                
                <!-- Add a comment form -->
                <div class="add-comment" id="addComment-${post.id}">
                    <h5>Add a comment:</h5>
                    <input type="text" id="commentName-${post.id}" placeholder="Your name">
                    <input type="text" id="commentBody-${post.id}" placeholder="Your comment">
                    <button class="postComment" data-post-id="${post.id}">Post Comment</button>
                </div>
            </div>
        `;
    });

    $('#posts').html(postsHtml);

    // Attach event listeners for "Show/Hide Comments" buttons
    $('.toggleComments').on('click', function () {
        const postId = $(this).data('post-id');  // Retrieve postId from data-post-id attribute
        const commentDiv = $(`#comments-${postId}`);
        if (commentDiv.is(':visible')) {
            commentDiv.hide();  // Hide comments if they are already visible
            $(this).text('Show Comments');
        } else {
            getPostComments(postId);  // Fetch and show comments if hidden
            $(this).text('Hide Comments');
        }
    });

    // Attach event listeners for "Post Comment" buttons
    $('.postComment').on('click', function () {
        const postId = $(this).data('post-id');
        const commentName = $(`#commentName-${postId}`).val();
        const commentBody = $(`#commentBody-${postId}`).val();

        if (commentName && commentBody) {
            postComment(postId, commentName, commentBody);

            $(`#commentName-${postId}`).val("");
            $(`#commentBody-${postId}`).val("");
        } else {
            alert('Please enter both name and comment.');
        }
    });
}

function getPostComments(postId) {
    // Fetch comments from backend for specific post
    $.get(`/comments?postId=${postId}`, function (comments) {
        displayPostComments(postId, comments);
    });
}

function displayPostComments(postId, comments) {
    let commentsHtml = '<h4>Comments</h4>';

    comments.forEach(comment => {
        commentsHtml += `
            <p><strong>${comment.name}:</strong> ${comment.body}</p>
        `;
    });

    $(`#comments-${postId}`).html(commentsHtml).show(); // Show the comments section
}

function postComment(postId, name, body) {
    // Post comment to the backend
    // $.post('/comments', {
    //     postId: postId,
    //     name: name,
    //     body: body
    // }).done(function (comment) {
    //     // Add the new comment to the post's comment section
    //     const newCommentHtml = `<p><strong>${comment.name}:</strong> ${comment.body}</p>`;
    //     $(`#comments-${postId}`).append(newCommentHtml);
    //     alert('Comment posted successfully!');
    // }).fail(function () {
    //     alert('Failed to post comment.');
    // });

    $.ajax("postComment.ajax", {
        "type": "post",
        "data": {
            "postId": postId,
            "name": name,
            "body": body
        }
    }).done(function(comment) {
        if (comment) {
            let commentsHtml = '<h4>Comments</h4>';
            commentsHtml += `
                <p><strong>${comment.name}:</strong> ${comment.body}</p>
            `;

            $(`#comments-${postId}`).html(commentsHtml).show();
            alert(`Your comment posted successfully!`);
        } else {
            alert('Cannot post your comment!');
        }
    });
}
