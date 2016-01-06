<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="h" uri="/struts-tags" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<%
String ip=request.getRemoteAddr();
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登录</title>
<link href="images/login.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="script/validation-framework.js" charset="GBK"></script>
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.captcha').focus(function(){
			$('.yzm-box').show();
			});
			
		$('.captcha').focusout(function(){
			$('.yzm-box').hide();
			});
		})
</script>

</head>
<body >
<div id="wrap">
	 <form action="adminlogin" method="post" >
	
	   <div id="header"> </div>
	   <div id="content-wrap">
    	<div class="space"> </div>
    	<center><font color="red"><h:actionerror/></font>
 <h:fielderror cssStyle="color:red;font-size:14px" ></h:fielderror>
</center>
   	 <div class="content">
        <div class="field"><label>账　户：</label><input name="admin.name"  type="text" />
         
        </div>
		<div class="field"><label>密　码：</label><input name="admin.password"  type="password" /><br /></div>
        <div class="btn"><input  type="submit" class="login-btn" value="" /></div>
        </div>
       
      </div></form>
    </div>
    <div id="footer"> </div>

</body>
</html>
