<%@page language="java" isELIgnored="false" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <h2>Farhan Calculator</h2>

         <form action="add">
                <label for="num1">Enter 1st Number :</label>
                <input type="text" id="num1" name="num1"><br>
                <label for="num2">Enter 2nd Number :</label>
                <input type="text" id="num2" name="num2"><br>
                <input type="submit" value="Submit">
            </form>

            <form action="addalien">
                <label for="aid">Enter Alien id :</label>
                <input type="text" id="aid" name="aid"><br>
                <label for="aname">Enter Alien name :</label>
                <input type="text" id="aname" name="aname"><br>
                <input type="submit" value="Submit">
            </form>

    </body>
</html>