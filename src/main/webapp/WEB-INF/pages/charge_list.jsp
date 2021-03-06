<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ridiculous
  Date: 2016/10/24
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", -10);
%>

<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/style.css">
    <script src="<%=path %>/resource/js/jquery-1.10.1.min.js"></script>
    <script src="<%=path %>/resource/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="max-width: 900px">
    <div class="tab_container">
        <div id="tab1" class="tab_content" style="display: block; ">
            <table class="table table-bordered">
                <tr>
                    <th>ID</th>
                    <th>产品ID</th>
                    <th>SECRET</th>
                    <th>产品描述</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${chargepoints}" var="chargepointinfo">
                    <tr>
                        <td>${chargepointinfo.id}</td>
                        <td>${chargepointinfo.pid}</td>
                        <td>${chargepointinfo.secret}</td>
                        <td>${chargepointinfo.description}</td>
                        <td>
                            <button class="btn">删除</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                Add
            </button>
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog fixed-width">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span
                                    aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form">
                                <div class="form-group">
                                    <label for="description">描述</label>
                                    <input type="text" class="form-control" id="description" placeholder="描述">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="addChargePoint">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    $(document).ready(function () {
        //Default Action
        //$(".tab_content").hide(); //Hide all content
        //$("ul.tabs li:first").addClass("active").show(); //Activate first tab
        //$(".tab_content:first").show(); //Show first tab content

        $("#tab1 td button").click(function () {
            parent = $(this).parent();
            var id = parent.parent().children().first().text();
            $.ajax({
                type: "GET",
                url: "/ismp/Configure/deleteChargePoint",
                data: {
                    id: id
                }
            });
            parent.parent().remove();
        });
        $('#addChargePoint').click(function () {
            description = $('#description').val();
            $.ajax({
                type: "GET",
                url: "/ismp/Configure/addChargePoint",
                data: {
                    productId: '${productid}',
                    desription: description
                }
            });
            $('#myModal').modal('hide')
        });
        $('#myModal').on('hidden.bs.modal', function (e) {
            window.location.reload();
        })
    });
</script>
</body>

</html>
