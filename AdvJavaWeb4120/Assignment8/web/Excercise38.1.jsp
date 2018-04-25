<%-- 
    Document   : Excercise38.1
    Created on : Apr 23, 2018, 3:59:56 PM
    Author     : harsh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorial Table</title>
    </head>
    <body>
        <h1>Factorial Table!</h1>
        <table border=="1">
            <% for(int i=0; i<10; i++){ %>
            <tr>
                <td><%=i%></td>
                <td><%= factorial(i)%></td>
            </tr>
            <% } %>
        </table>
        
        <%!
        public long factorial(int n)
            {
            if(n==0){
            return 1;
            }
            else{
            return n*factorial(n-1);
            }
            }
        %>
          
    </body>
</html>
