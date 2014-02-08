<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="d" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Hello <d:title />!</title>
    </head>
    <body>
        <header>
            Header in decorator
        </header>
        <article>
            <d:body />
        </article>
        <footer>
            Footer in decorator
        </footer>
    </body>
</html>