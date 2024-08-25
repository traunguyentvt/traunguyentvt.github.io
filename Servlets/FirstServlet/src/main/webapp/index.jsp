<html>
<body>
<a href=hello>Start the simplest servlet app</a>

<p> Test JSP: </p>

<%! int count = 0 ; %>
The count is now:
<%= ++count %>

<%-- This is a jsp scriptlet that increments the count --%>
<!-- This is an html comment inserted by the increment comment -->

<% count = count * 10; %>

<p></p>

The count is now:
<%= count %>

</body>
</html>
