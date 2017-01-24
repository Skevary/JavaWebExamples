<jsp:root version="2.0" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns="http://www.w3.org/1999/xhtml">
    <jsp:directive.page contentType= "text/html; charset=UTF-8" />
    <html>
        <head>
            <title>My EJB</title>
        </head>
        <body>
            ${result}
            <form action="message" method="post">
                Enter your name:<input type="text" name="name" value=""/>
                <input type="submit" value="Submit"/>
            </form>
        </body>
    </html>
</jsp:root>