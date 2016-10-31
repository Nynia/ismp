<%--
  Created by IntelliJ IDEA.
  User: Ridiculous
  Date: 2016/7/14
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored ="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", -10);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="<%=basePath%>">
    <title>订购确认</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/style.css">
    <script src="<%=path %>/resource/js/jquery-1.10.1.min.js"></script>
    <script src="<%=path %>/resource/js/bootstrap.min.js"></script>
    <script src="<%=path %>/resource/js/sha1.js"></script>
    <script>

        var curCount;
        var secret;
        var productid;
        var spid;

        function SetRemainTime() {
            if (curCount == 0) {
                window.clearInterval(InterValObj);//停止计时器
                $("#getvercode").removeAttr("disabled");//启用按钮
                $("#getvercode").val("重新发送验证码");
            }
            else {
                curCount--;
                $("#getvercode").val("请在" + curCount + "秒内输入验证码");
            }
        }

        function getUrlVars() {
            var vars = {};
            var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
                    function(m,key,value) {
                        vars[key] = value;
                    }
            );
            return vars;
        }
        $(document).ready(function () {

            $('#getvercode').click(function () {
                var phonenum = $('#phonenum').val();

                if (phonenum == "") {
                    alert("手机号码不能为空");
                }
                else {
                    var partten = /^1\d{10}$/;
                    if (!partten.test(phonenum)) {
                        alert("号码格式不正确");
                    }
                    else {
                        $('#getvercode').hide();
                        $('#J_second').html('60');
                        $('#reset').show();
                        var second = 60;
                        var timer = null;
                        timer = setInterval(function(){
                            second -= 1;
                            if(second >0 ){
                                $('#J_second').html(second);
                            }else{
                                clearInterval(timer);
                                $('#getvercode').show();
                                $('#reset').hide();
                            }
                        },1000);
                        $.ajax({
                            url: 'http://127.0.0.1:8080/serviceOrder',
                            type: 'post',
                            dataType:'json',
                            data: {
                                action:'subscribe',
                                orderId:'${orderId}',
                                phoneNum: phonenum
                            },
                            success: function (msg) {
                               //alert(msg.error);
                            },
                            error: function () {
                                alert("异常！");
                            }
                        });
                    }
                }
            });
            $('#ok').click(function () {
                var phonenum = $('#phonenum').val();
                var orderid = '${orderId}';
                var vercode = $('#vercode').val();
                if (phonenum == "" || vercode == "") {
                    alert("手机号码或验证码不能为空");
                }
                else {
                    var partten = /^1\d{10}$/;
                    if (!partten.test(phonenum)) {
                        alert("号码格式不正确");
                    }
                    else {
                        $.ajax({
                            url: 'http://127.0.0.1:8080/serviceOrder',// 跳转到 action
                            type: 'post',
                            dataType:'json',
                            data: {
                                action: 'subscribe',
                                orderId: orderid,
                                phoneNum: phonenum,
                                verCode: vercode
                            },
                            success: function (msg) {
                                var err_code = msg.err_code;
                                switch (err_code) {
                                    case '0':
                                        alert("订购成功");
                                        window.history.back(-1);
                                        break;
                                    case '131':
                                        alert("订购关系已存在，请勿重复订购");
                                        window.history.back(-1);
                                        break;
                                    case '126':
                                        alert('用户余额不足，未能成功订购');
                                        window.history.back(-1);
                                        break;
                                    case '155':
                                        alert('验证码错误，未能成功订购');
                                        window.history.back(-1);
                                        break;
                                    default:
                                        alert('未知错误，未能成功订购');
                                        window.history.back(-1);
                                }
                            },
                            error: function () {
                                alert("异常！");
                            }
                        });
                    }
                }
            });
        });

    </script>
</head>
<body>
<div class="container">
    <h4 class="modal-title" id="title">${title}订购页面</h4>
        <div class="modal-body">
            <p>${desc}</p>
        </div>
        <div class="row">
            <input type="text" class="form-control" id="phonenum" placeholder="请输入手机号">
            <input type="text" value="" style="display:none" id="orderid">
        </div>
        <div class="holder">
        </div>
        <div class="row">
            <div class="col-xs-8 no-padding">
                <input type="text" class="form-control" id="vercode" placeholder="请输入验证码">
            </div>
            <div class="col-xs-4 no-padding">
                <button type="submit" class="btn btn-primary btn-block" value="" style="display:none" id="reset">
                    <span id="J_second">60</span>秒后重发
                </button>
                <button type="submit" id="getvercode" class="btn btn-primary btn-block">获取验证码</button>

            </div>
        </div>
        <div id="submit">
            <button type="submit" id="ok" class="btn btn-primary btn-block">提交</button>
        </div>
</div>
</body>
</html>
