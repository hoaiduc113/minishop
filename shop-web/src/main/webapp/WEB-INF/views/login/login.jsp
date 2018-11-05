<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglib.jsp" %>
<%--<c:url var="formUrl" value="/login.html"/>--%>

<html>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>


</head>
<body id="body-login">
<div>
    <form id="ajax" action=${pageContext.request.contextPath}></form>
</div>

<div id="body-flex-login">
    <div id="container-login">
        <div id="container-login-left">
            <div id="header-top-left" class="header-login">
                <span id="text-logo">Welcome</span><br/>
                <span id="hint-text-logo">Hãy tạo nên phong cách của bạn cùng Minishop ! </span>
            </div>

            <div id="header-bottom-left">
                <p><img alt="icon_oval" src='<c:url value="/template/web/images/icon_oval.png" />'/><span>Luôn cập nhật xu hướng thời trang mới nhất </span>
                </p>
                <p><img alt="icon_oval" src='<c:url value="/template/web/images/icon_oval.png" />'/><span>Giảm hơn 50% tất cả các mặt hàng giành cho khách VIP </span>
                </p>
                <p><img alt="icon_oval" src='<c:url value="/template/web/images/icon_oval.png" />'/><span>Tận tình tư vấn để tạo nên phong cách của bạn</span>
                </p>
            </div>
        </div>

        <div id="container-login-right">
            <div id="header-top-right" class="header-login">
                <span class="actived" id="dangnhap">Đăng nhập</span> / <span id="dangky">Đăng ký</span>
            </div>

            <div id="container-center-login-right">
                <div class="container-login-form" id="container-center-login-right">
                    <form action="" method="post" id="formlogin">
                        <input id="email" name="emails" class="material-textinput input-icon-email" placeholder="Email"
                               type="text"/><br/>
                        <input id="loginpassword" name="passwords" class="material-textinput input-icon-password"
                               placeholder="Mật khẩu " type="text"/><br/>
                        <input id="btnDangNhap" class="material-primary-button" type="submit" value="ĐĂNG NHẬP" / ><br/>
                    </form>
                </div>

                <div class="container-signup-form" id="container-center-login-right">
                    <form action="" method="post" id="formregistration">
                        <input id="emails" name="email" class="material-textinput input-icon-email" placeholder="Email"
                               type="text"/><br/>
                        <p></p>
                        <input id="matkhaus" name="matkhau" class="material-textinput input-icon-password"
                               placeholder="Mật khẩu " type="password"/><br/>
                        <p></p>
                        <input id="nhaplaimatkhaus" name="nhaplaimatkhau" class="material-textinput input-icon-password"
                               placeholder="Nhập lại mật khẩu " type="password"/><br/>
                        <input id="btnDangKy" class="material-primary-button" type="submit" value="ĐĂNG KÝ"/><br/>
                        
                    </form>

                </div>


                <span id="ketqua"></span>
                <span id="kiemtra">${kiemtradangnhap}</span>
            </div>

            <div id="container-social-login">
                <img alt="icon_oval" src='<c:url value="/template/web/images/icon_facebook.png" />'/>
                <img alt="icon_oval" src='<c:url value="/template/web/images/icon_google.png" />'/>
            </div>


        </div>

    </div>
</div>


<script type="text/javascript">
    $(document).ready(function () {
        // $("#ketqua").text("Email không được rỗng");
        $("#dangnhap").click(function () {

            $(this).addClass("actived");
            $("#dangky").removeClass("actived");
            $(".container-login-form").show();
            $(".container-signup-form").css("display", "none");
        });

        $("#dangky").click(function () {

            $(this).addClass("actived");
            $("#dangnhap").removeClass("actived");
            $(".container-login-form").hide();
            $(".container-signup-form").show();
        });
        $("#btnDangNhap").click(function (event) {


            $('#formlogin').validate(
                {
                    rules: [],
                    messages: [],
                    submitHandler: function (form) {
                        event.preventDefault();
                        var formLogin = $("#formlogin").serializeArray();
                        json = {};
                        $.each(formLogin, function (key, value) {
                            json[value.name] = value.value;
                        })
                        $.ajax({
                            url: "/ajax/login",
                            type: "POST",
                            data: {
                                dataJson: JSON.stringify(json)
                            },
                            success: function (value) {


                                if (value == 1) {
                                    currentLink = window.location.href;
                                    link = currentLink.replace("/login/", "");
                                    window.location = link;

                                }
                                else {
                                    $("#ketqua").text("đăng nhập thất bại");
                                }


                            }
                        })
                    }
                });
            $("#email").rules("add", {
                required: true,
                messages:
                    {
                        required: "Email không được rỗng"
                    }

            });
            $("#loginpassword").rules("add", {
                required: true,
                messages:
                    {
                        required: "mật khẩu không được rỗng"
                    }

            });


        })
        $("#btnDangKy").click(function (event)
        {
            $('#formregistration').validate(
                {
                    rules: [],
                    messages: [],
                    submitHandler: function (form) {
                        event.preventDefault();
                        var formregistration = $("#formregistration").serializeArray();
                        json = {};
                        $.each(formregistration, function (key, value) {
                            json[value.name] = value.value;
                        })
                        $.ajax({
                            url: "/ajax/registration",
                            type: "POST",
                            data: {
                                dataJson: JSON.stringify(json)
                            },
                            success: function (value) {
                                 var This=  $("#dangnhap");
                                 if(value==true)
                                 {
                                     $(This).addClass("actived");
                                     $("#dangky").removeClass("actived");
                                     $(".container-login-form").show();
                                     $(".container-signup-form").css("display", "none");
                                 }
                                 else
                                 {
                                     $("#ketqua").text("email của bạn đã tồn tại");
                                 }
                            }
                        })
                    }

                });
            $("#emails").rules("add", {
                required: true,
                messages:
                    {
                        required: "email không được rỗng"
                    }
            });
            $("#matkhaus").rules("add", {
                required: true,
                messages:
                    {
                        required: "mật khẩu không được rỗng",
                    }
            });
            $("#nhaplaimatkhaus").rules("add", {
                required: true,
                equalTo: "#matkhaus",

            });

        })

    })


</script>
</body>
</html>
