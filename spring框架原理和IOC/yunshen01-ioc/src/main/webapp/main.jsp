
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8" />
    <title>Main</title>
    <link rel="stylesheet" href="3rd/bootstrap/css/bootstrap.min.css"/>
    <style>
        html, body{
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }
        .main{
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction:column;
        }
        .main > div:nth-child(1){
            width: 100%;
            min-height: 51px;
            max-height: 51px;
        }
        .main > div:nth-child(2){
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction:row;
        }
        .main > div:nth-child(2) > div:first-child{
            min-width: 200px;
            max-width: 200px;
            height: 100%;
            padding-top: 5px;

        }
        .main > div:nth-child(2) > div:last-child{
            width: 100%;
            height: 100%;

        }
        .main > div:nth-child(3){
            width: 100%;
            min-height: 30px;
            max-height: 30px;
            text-align: center;
            line-height: 30px;
            border-top: #a7a7a7 1px solid;
        }
        .menupanel{
            padding: 0;

        }
        .menupanel button{
            text-align: left;
        }
        .mainiframe{
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div class="main">
    <div>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Brand</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">


                    <ul class="nav navbar-nav navbar-right">

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                系统操作<span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="exitlogin">退出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>

    <div>
        <div>
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#userManger" aria-expanded="true" aria-controls="collapseOne">
                                用户管理
                            </a>
                        </h4>
                    </div>
                    <div id="userManger" class="panel-collapse collapse in " role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body menupanel">
                            <button type="button" class="btn btn-link btn-block user1" url="http://www.taobao.com">淘宝</button>
                            <button type="button" class="btn btn-link btn-block user1" url="http://www.baidu.com">百度</button>
                            <button type="button" class="btn btn-link btn-block user1" url="http://www.bilibili.com">哔哩哔哩</button>
                            <button type="button" class="btn btn-link btn-block user1" url="tab.html">用户数据</button>

                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#zhangHAO" aria-expanded="false" aria-controls="collapseTwo">
                                账号管理
                            </a>
                        </h4>
                    </div>
                    <div id="zhangHAO" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body menupanel">
                            <button type="button" class="btn btn-link">（链接）Link</button>
                            <button type="button" class="btn btn-link">（链接）Link</button>
                            <button type="button" class="btn btn-link">（链接）Link</button>

                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#sysSet" aria-expanded="false" aria-controls="collapseThree">
                                系统管理
                            </a>
                        </h4>
                    </div>
                    <div id="sysSet" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                        <div class="panel-body menupanel">
                            <button type="button" class="btn btn-link">（链接）Link</button>
                            <button type="button" class="btn btn-link">（链接）Link</button>
                            <button type="button" class="btn btn-link">（链接）Link</button>

                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingFlor">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#dateSet" aria-expanded="false" aria-controls="collapseTwo">
                                数据管理
                            </a>
                        </h4>
                    </div>
                    <div id="dateSet" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body menupanel">
                            <button type="button" class="btn btn-link">（链接）Link</button>
                            <button type="button" class="btn btn-link">（链接）Link</button>
                            <button type="button" class="btn btn-link">（链接）Link</button>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingThre">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                信息管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body menupanel">
                            <button type="button" class="btn btn-link">（链接）Link</button>
                            <button type="button" class="btn btn-link">（链接）Link</button>
                            <button type="button" class="btn btn-link">（链接）Link</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div>
            <iframe class="mainiframe" src="tab.html"></iframe>
        </div>
    </div>

    <div>
        2023版权所有 ys1834783
    </div>
</div>


<script src="3rd/jquery-2.2.4.min.js"></script>
<script src="3rd/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(".user1").bind("click",function(){
        var url = $(this).attr("url");
        $(".mainiframe").attr("src",url);
    });
</script>
</body>
</html>

