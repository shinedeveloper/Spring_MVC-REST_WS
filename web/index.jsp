<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Films welcome page</title>
    <style type="text/css">
        div { font-size: 2em; }
    </style>
</head>
<body>
    <div style="font-size: 3em">
        The web app <b><%= application.getContextPath() %></b> is deployed!
    </div>

    <div>
        Random number (app is alive): <%= (int)(Math.random()*100.0) %>
    </div>
    
    <div>
        Try to go to this link: [XML] <a href="films/all">/films/all</a>
        <br/>
        Try to go to this link: [JSON] <a href="films/all.json">/films/all</a>
        <br/>
        And this link: <a href="films/10.xml">/films/10.xml</a>
        <br/>
        And also this link: <a href="films/10.json">/films/10.json</a>
    </div>
    
</body>
</html>
