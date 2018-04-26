<%-- 
    Document   : BigFactorial
    Created on : Apr 25, 2018, 3:24:07 PM
    Author     : harsh
--%>

<%@page import="java.math.BigInteger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ page import = "java.Biginteger.math.util"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Big Factorial</title>
    </head>
    <body>
        <h1>Calculate Big Factorial</h1>
        <form method="get" action="BigFactorial.jsp">
            <label>Number</label>
            <input type="text" name="number"/>
            <br />
            <br />
            <input type="submit" value="Calculate"/>
        </form>
        <h3>Result</h3>
        <p>
            <%
                String numberString = request.getParameter("number");
                if(numberString != null)
                {
                    BigInteger number = new BigInteger(numberString);
                    BigInteger result = BigInteger.ONE;
                    
                    for(BigInteger i = BigInteger.ONE;
                            i.compareTo(number) <= 0;
                            i = i.add(BigInteger.ONE))
                    {
                        result = result.multiply(i);
                    }
                    out.println("Number: "+number);
                    out.println("<br />");
                    out.println("Result"+ "!: "+ result);
                }
                
            %>
        </p>
    </body>
</html>
