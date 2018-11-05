<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><dec:title default="Admin Page" /></title>
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>

    <link  rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />

    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/animate.min.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/bootstrap-switch.min.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/checkbox3.min.css' />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/jquery.dataTables.min.js' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/dataTables.bootstrap.css' />"  />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/select2.min.css' />"  />
    <!-- CSS App -->
    <script type="text/javascript" src='<c:url value="/template/web/vendor/jquery/jquery-3.2.1.min.js"/>'></script>

    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/style.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/custom-style.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/themes/flat-blue.css'/>"  />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/admin/assets/css/fileinput.css' />"/>
    <script type="text/javascript" src="<c:url value='/template/admin/lib/js/select2.full.min.js' />"></script>



    <%--sweetalert--%>
    <script type='text/javascript' src='<c:url value="/template/web/sweetalert/sweetalert2.min.js"/>'></script>
    <link rel="stylesheet" href="<c:url value="/template/web/sweetalert/sweetalert2.min.css"/>">
    <script src="<c:url value='/template/web/js/jquery.validate.min.js' />"></script>

    <dec:head />
</head>
<body class="flat-blue">
<div class="app-container">
    <div class="row content-container">


            <%@ include file="/common/admin/header.jsp" %>
    <!-- Begin menu -->

    <%@ include file="/common/admin/menu.jsp" %>


    <!-- Begin body -->
    <dec:body/>
    <!-- End body -->
        <%--<script src="<c:url value='/template/admin/assets/js/jquery.min.js' />"></script>--%>


    <!-- Begin footer -->
    <%@ include file="/common/admin/footer.jsp" %>
    <!-- end footer -->

</div>
</div>

<!-- /.main-container -->








</body>
<script type="text/javascript" src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/lib/js/Chart.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/lib/js/bootstrap-switch.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/lib/js/jquery.matchHeight-min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/lib/js/jquery.dataTables.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/lib/js/dataTables.bootstrap.min.js' />"></script>

<script type="text/javascript" src="<c:url value='/template/admin/lib/js/ace/ace.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/lib/js/ace/mode-html.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/lib/js/ace/theme-github.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/js/app.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/js/fileinput.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/js/tinymce/jquery.tinymce.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/js/tinymce/tinymce.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/admin/js/jquery.bootpag.js' />"></script>

</html>