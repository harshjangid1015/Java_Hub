<%-- 
    Document   : Excercise38.20
    Created on : Apr 25, 2018, 3:43:29 PM
    Author     : harsh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="numberBox" scope="session" class="xd.NumberBox" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guess Number</title>
    </head>
    <body>
        <h1>Guess the Number</h1>
        <form method="get" action="Excercise38.20.jsp">
            <label>Guess</label>
            <input type="text" name="guess"/>
            <br />
            <br />
            <input type="submit" value="Enter Guess"/>
        </form>
        
        <h3>Result</h3>
        <%
            String guessString =  request.getParameter("guess");
           
            if(guessString != null){
            int guess = Integer.parseInt(guessString);
            int number = numberBox.getMagicNumber();
         
                if(guess == number){
                    out.println("You won, its! " + number);
                    numberBox.generateNumber();
                    out.println("<br />");
                    out.println("Start playing again!");
                }
                else if(guess < number){
                    out.println("too low!");
                }
                else{
                    out.println("too high!");
                }
            }
            
            out.println("<br />");
            
            out.println("guess = " + guessString);
            
            out.println("<br />");
            
            out.println("magicNumber "+ numberBox.getMagicNumber());
        %>
    </body>
</html>
