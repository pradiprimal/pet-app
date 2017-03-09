<%-- 
    Document   : managePetInfo
    Created on : Mar 8, 2017, 8:15:42 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!--<pre>{{petInfos|json}}</pre>-->
        <div ng-repeat=" petInfo in petInfos">
            <div>
                <img ng-src="data:image/;base64,{{petInfo.image_path}}">
            </div>
        </div>
    </body>
</html>
