<%-- 
    Document   : index
    Created on : Mar 7, 2017, 9:12:52 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="pages/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet App</title>
        <script src="pages/js/angular.min.js"></script>
        <script src="pages/js/angular-route.js"></script>
        <script src="app.js"></script>
        <script src="common/directive/fileUpload.js"></script>
        <script src="pages/js/angular-base64.min.js"></script>
        <script src="pages/js/angular-base64-upload.js"></script>
        <!--<script src="pages/js/bootstrap.min.js"></script>-->
    </head>
    <body ng-app="PetApp">
        <div>
            <a href="#/add" target="_self">Add</a>
            <a href="#/manage" target="_self">Manage</a>
        </div>
        <div ng-view="">

        </div>
        <script src="<c:url value="/common/HttpService.js"/>"></script>
        <script src="<c:url value="/pages/petManagement/petManagementService/PetManagementService.js"/>"></script>
        <script src="<c:url value="/pages/petManagement/petManagementController/PetManagementController.js"/>"></script>
    </body>
</html>
