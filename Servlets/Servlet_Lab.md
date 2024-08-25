### Overview

### Servlet Labs

### Status report:
  - Calculator:
    + I completed all parts of Calculator Web App.
      I created 2 projects: Simple and Improved Calculator.
      It is not easy to set up the Tomcat server.
      It took me a day to figure out why the Servlet Server is crashed.
      We should use Tomcat with 9.x version.

  - Servlets Demystified (write, deploy, run):
    + 1. What is the purpose of the directory structure given on p. 30?
       -> To help understand the overall structure of the project.
    + 2. What is the purpose of the directory structure given on p. 31?
       -> To help understand how Tomcat server connects and integrates with Web app.
    + 3. Why do you need to be in the project1 directory for step 5?
       -> To help understand the command and compile the project.
    + 4. Why is the copying of step 6 necessary?
       -> To identify which Servlet Class will be used in web.xml
    + 5. Where is the name of the web app defined? Try changing it.
       -> The webapp is named ch1. Can change it by renaming the module.
    + 6. Why is step 9 necessary? Try changing display text in the servlet. What steps are necessary for your changes to appear in the browser?
       -> It is necessary to stop Tomcat server and restart again to apply the new changes. It will appear in the browser.
    + 7. Describe an interesting problem you encountered (if any) and how you solved it.
       -> This lab is very complicated for me to do in the first time as I have less knowledge about Server Side. One of my biggest problems is Servlet was crashed when I run the web app. I did not realize why it happened. I read the documents again and again, then I found that Tomcat 10.x is not compatible with the current SDK. I tried to downgrade Tomcat to the 9.x version. I finally solved the problems. I took me a lot of time to solve it.

  - Beer Advisor:
    + This lab is really helpful to understand the Servlet and JSP page. I created BeerAdvisorServlet to handle server side. The index.jsp displays the firt page when user visits, and the result.jsp shows the result when user submits his choice. I finish almost the requirements of this lab except Unit Test.