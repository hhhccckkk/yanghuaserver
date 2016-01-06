<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="h" uri="/struts-tags" %>
<%@ include file="session.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理界面</title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $('.yingcang').toggle();
  return false;
});
</script>

<script type="text/javascript">
$(function(){
	//setMenuHeight
	$('.menu').height($(window).height()-51-27-26-5);
	$('.sidebar').height($(window).height()-51-27-26-5);
	$('.page').height($(window).height()-51-27-26-5);
	$('.page iframe').width($(window).width()-15-168);
	
	//menu on and off
	$('.btn').click(function(){
		$('.menu').toggle();
		
		if($(".menu").is(":hidden")){
			$('.page iframe').width($(window).width()-15+5);
			}else{
			$('.page iframe').width($(window).width()-15-168);
				}
		});
		
	//
	$('.subMenu a[href="#"]').click(function(){
		$(this).next('ul').toggle();
		return false;
		});
})
</script>
<style type="text/css">
<!--
.STYLE1 {
	
	font-weight: bold;
}
-->
</style>
</head>
<body style="overflow-y:hidden">
<div id="wrap">
	<div id="header">
    <div class="logo fleft"></div>
    
    <div class="nav fleft">
    	<ul>
        	<div class="nav-left fleft"></div>
            <li><a href="getTieZis" target=right>帖子</a></li>
             <li><a href="getusers?page=1" target=right>用户</a></li>
             <li><a href="getEndOrder?page=1" target=right>已处理订单</a></li>
            <li><a href="showOverOrder?page=1" target=right>未处理订单</a></li>
            <li><a href="getMyOrder?page=1" target=right>我的订单</a></li>
              <li><a href="getDX?page=1" target=right>消息</a></li>
            <div class="nav-right fleft"></div>
        </ul>
    </div>
    <a class="logout fright" onclick="if(confirm('确定退出吗'))window.location='tuichuok.jsp'"{window.opener=null;window.close();}"> </a>
    <div class="clear"></div>
    <div class="subnav">
    	<div class="subnavLeft fleft"></div>
        <div class="fleft"></div>
        <div class="subnavRight fright"></div>
    </div>
    </div><!--#header -->
    <div id="content">
    <div class="space"></div>
    <div class="menu fleft">
    	<ul>
        	<li class="subMenuTitle">功能列表</li>
        	<li class="subMenu"><a href="#">类别管理</a>
            	<ul class="yingcang">
                    <li><a href="addKind.jsp" target="right">增加赚钱区</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">我的应用管理</a>
            	<ul class="yingcang">
                    <li><a href="addApp.jsp" target="right">增加应用</a></li>
                    <li><a href="getAllApps?page=1" target="right">全部应用</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">赚钱记录</a>
            	<ul class="yingcang">
                    <li><a href="getMoneyAllP?type=1&page=1" target="right">今天赚钱记录</a></li>
               
                
                    <li><a href="getMoneyAllP2?type=2&page=1" target="right">昨天赚钱记录</a></li>
               
               
                    <li><a href="getMoneyAllP3?type=3&page=1" target="right">前天赚钱记录</a></li>
                </ul>
            </li>
            
            
            
             <li class="subMenu"><a href="#">赚钱排行</a>
            	<ul class="yingcang">
                    <li><a href="getRank1?page=1" target="right">赚钱总榜</a></li>
                    <li><a href="getRank2?page=1" target="right">推广总榜</a></li>
                </ul>
            </li>
            
            <li class="subMenu"><a href="#">用户管理</a>
            	<ul class="yingcang">
            	<li><a href="addUser.jsp" target="right">增加用户</a></li>
                	<li><a href="searchUser.jsp" target="right">搜索用户</a></li>
                	<li><a href="getUserSize" target="right">用户统计</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">订单管理</a>
            <ul class="yingcang">
            <li><a href="addOrder.jsp" target="right">增加订单</a></li>
            <li><a href="searchOrder.jsp" target="right">搜索订单</a></li>
            </ul>
            </li>
           <li class="subMenu"><a href="#">版本管理</a>
            	<ul class="yingcang">
                    <li><a href="addVison.jsp" target="right">增加版本</a></li>
                     <li><a href="getVison" target="right">版本信息</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">新闻管理</a>
            	<ul class="yingcang">
                    <li><a href="addNew.jsp" target="right">增加新闻</a></li>
                    <li><a href="getNews" target="right">查看新闻</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">分享管理</a>
            <ul class="yingcang">
             <li><a href="getShare" target="right">分享信息</a></li>
             <li><a href="addShare.jsp" target="right">增加分享</a></li>
                </ul>
            </li>
          <li class="subMenu"><a href="#">短信息管理</a>
            <ul class="yingcang">
             <li><a href="addMessage.jsp" target="right">增加短信息</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="sidebar fleft"><div class="btn"></div></div>
    <div class="page">
    <iframe width="100%" scrolling="auto" height="100%" frameborder="false" allowtransparency="true" style="border: medium none;" src="main.jsp" id="rightMain" name="right"></iframe>
    </div>
    </div><!--#content -->
    <div class="clear"></div>
    <div id="footer">版权所有——蝌蚪笑话 ; 2012-10 www.hck.com </div><!--#footer -->
</div><!--#wrap -->
</body>
</html>

