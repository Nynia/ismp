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
                    <th>产品ID</th>
                    <th>产品名称</th>
                    <th>产品价格</th>
                    <th>产品描述</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${productinfos}" var="productinfo">
                    <tr>
                        <td><a href="Configure/productDetail?productid=${productinfo.productId}">${productinfo.productId}</a></td>
                        <td>${productinfo.productName}</td>
                        <td>${productinfo.price}</td>
                        <td>${productinfo.description}</td>
                        <td>
                            <button class="btn">编辑</button>
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
                                    <label for="productid">产品ID</label>
                                    <input type="text" class="form-control" id="productid" placeholder="产品ID">
                                </div>
                                <div class="form-group">
                                    <label for="productname">产品名称</label>
                                    <input type="text" class="form-control" id="productname" placeholder="产品名称">
                                </div>
                                <div class="form-group">
                                    <label for="price">产品价格</label>
                                    <input type="number" class="form-control" id="price" placeholder="价格">
                                </div>
                                <div class="form-group">
                                    <label for="description">描述</label>
                                    <input type="text" class="form-control" id="description" placeholder="描述">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="addProduct">Save changes</button>
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
            if ($(this).text() == '编辑') {
                parent.prevAll().each(function (index) {
                    value = $(this).text();
                    width = $(this).width();
                    $(this).html('<input type="text" style="width: ' + width + 'px"' + ' value="' + value + '">');

                });
                $(this).text('确认');
            }
            else if ($(this).text() == '确认') {
                var sibling = parent.prevAll();
                $.ajax({
                    type: "GET",
                    url: "/ismp/Configure/updateProduct",
                    data: {
                        productId: sibling.children(":eq(3)").val(),
                        productName: sibling.children(":eq(2)").val(),
                        price: sibling.children(":eq(1)").val(),
                        description: sibling.children(":first").val()
                    }
                });
                parent.prevAll().each(function (index) {
                    value = $(this).find('input').first().val();
                    if (index == 3)
                        $(this).html("<a href=\"Configure/productDetail?productid=" + value + "\">" + value);
                    else
                        $(this).html(value);
                });
                $(this).text('编辑');
            }
            else {
                var id = parent.parent().children().first().text();
                $.ajax({
                    type: "GET",
                    url: "/ismp/Configure/deleteProduct",
                    data: {
                        productId: id
                    }
                });
                parent.parent().remove();
            }
        });
        $('#addProduct').click(function () {
            id = $('#productid').val();
            name = $('#productname').val();
            price = $('#price').val();
            description = $('#description').val();
            $.ajax({
                type: "GET",
                url: "/ismp/Configure/addProduct",
                data: {
                    spId:${spid},
                    productId: id,
                    productName: name,
                    price: price,
                    decription: description
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
