package nvntrau.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(urlPatterns = {"/userposts", "/comments"})
public class UserPostsServlet extends HttpServlet {

    // Handle GET requests for user data and comments
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String postId = request.getParameter("postId");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        if (userId != null) {
            // Simulate fetching user data
            JSONObject user = getUserDataById(userId);
            if (user != null) {
                out.print(user.toString());
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
            }
        } else if (postId != null) {
            // Fetch comments for the post
            JSONArray comments = getCommentsForPost(postId);
            out.print(comments.toString());
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
        }
    }

    // Handle POST requests to add comments
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId");
        String name = request.getParameter("name");
        String body = request.getParameter("body");

        if (postId != null && name != null && body != null) {
            // Create a new comment
            JSONObject newComment = new JSONObject();
            newComment.put("postId", postId);
            newComment.put("name", name);
            newComment.put("body", body);

            // Return the newly created comment as the response
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();
            out.print(newComment.toString());
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
        }
    }

    // Simulated method to retrieve user data (replace with actual database queries)
    private JSONObject getUserDataById(String userId) {
        if ("1".equals(userId)) {
            JSONObject user = new JSONObject();
            user.put("name", "John Doe");
            user.put("email", "john@example.com");

            JSONObject address = new JSONObject();
            address.put("street", "123 Main St");
            address.put("city", "Anytown");
            user.put("address", address);

            JSONArray posts = new JSONArray();

            JSONObject post1 = new JSONObject();
            post1.put("id", 1);
            post1.put("title", "First Post");
            post1.put("body", "This is the body of the first post.");
            posts.put(post1);

            JSONObject post2 = new JSONObject();
            post2.put("id", 2);
            post2.put("title", "Second Post");
            post2.put("body", "This is the body of the second post.");
            posts.put(post2);

            user.put("posts", posts);

            return user;
        }
        return null;
    }

    // Simulated method to retrieve comments for a post (replace with actual database query)
    private JSONArray getCommentsForPost(String postId) {
        JSONArray comments = new JSONArray();

        if ("1".equals(postId)) {
            JSONObject comment1 = new JSONObject();
            comment1.put("name", "Alice");
            comment1.put("body", "This is a comment for post 1.");
            comments.put(comment1);

            JSONObject comment2 = new JSONObject();
            comment2.put("name", "Bob");
            comment2.put("body", "Another comment for post 1.");
            comments.put(comment2);
        }

        return comments;
    }
}
