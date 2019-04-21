<html>
<#include "../common/header.ftl">
<h2 align="center">登陆页面</h2>
<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#--<#include "../common/nav.ftl">-->

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/login">
                        <div class="form-group">
                            <label>用户名</label>
                            <input name="username" type="text" class="form-control" value="${(username)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="password" class="form-control" value="${(password)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>

</body>
</html>