<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%><%@ include file="/common/tag.jsp"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd"><html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><meta name="keywords" content="rsa, demo, online, asymmetric, javascript, library, encryption, secrurity, base64, utf8, asn, pem">  <meta name="description" content="Demonstrates the RSA encryption and decryption with the javascript crypto library pidCrypt."><title>容易移动商品管理系统</title><link href="${ctx}/css/jquery-ui.css" type="text/css" rel="stylesheet" /><link href="${ctx}/css/index.css" type="text/css" rel="stylesheet" /><script src="${ctx}/js/jquery.js" type="text/javascript"></script><script src="${ctx}/js/jquery.md5.js" type="text/javascript"></script><%-- <script src="${ctx}/js/jquery-1.10.2.js" type="text/javascript"></script> --%><script src="${ctx}/js/jquery-ui.js" type="text/javascript"></script><script language="JavaScript" type="text/javascript" src="${ctx}/js/hash.js"></script><script language="JavaScript" type="text/javascript" src="${ctx}/js/jsbn.js"></script><script language="JavaScript" type="text/javascript" src="${ctx}/js/random.js"></script><script language="JavaScript" type="text/javascript" src="${ctx}/js/base64.js"></script><script language="JavaScript" type="text/javascript" src="${ctx}/js/rsa.js"></script> <%-- <script src="${ctx}/js/index.js" type="text/javascript"></script> --%><script src="${ctx}/js/login.js" type="text/javascript"></script><script>	$(function() {		$(".CheckBox").button();	});</script><style type="text/css">/*复选框按钮*/.ui-button-text-only .ui-button-text {	padding: 5px 0px 5px 25px;	line-height: 20px;	color: #3a3a3a;}.ui-state-default, .ui-widget-content .ui-state-default,	.ui-widget-header .ui-state-default {	background: url("../images/icon_input.png") 0 6px no-repeat;	border: none;}.ui-state-hover, .ui-widget-content .ui-state-hover, .ui-widget-header .ui-state-hover,	.ui-state-focus, .ui-widget-content .ui-state-focus, .ui-widget-header .ui-state-focus	{	background: url("../images/icon_input.png") 0 6px no-repeat;	border: none;}.ui-state-active, .ui-widget-content .ui-state-active, .ui-widget-header .ui-state-active	{	background: url("../images/icon_input2.png") 0 6px no-repeat;	border: none;}</style><script language="JavaScript">	if (window != top) {		top.location.href = location.href;	}	var salt = "{Grass}";</script></head><body onload="document.f.j_username.focus();" onkeydown="login();">	<div class="top">		<div class="top-left">			<div class="logo"></div>			<span>容易网 | 移动商品管理系统</span>		</div>		<div class="top-right">			<!-- 		<span>2014年9月1日</span> -->			<!-- 		<span>欢迎：姚静莉（管理员） |  &nbsp;<a href="#">注销</a></span> -->		</div>	</div>	<div class="con">		<div class="login">			<div class="login-bg"></div>			<div class="login-center">				<form name='f' action="${ctx}/j_spring_security_check" method="post">					<div class="login-title" >${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message == 'Bad credentials' ? '账号或密码有误' : sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</div>					<div class="login-user">						<p>							<span class="icon-user"></span> <input type="text" id="username"								name="j_username" placeholder="请输入您的账号" />						</p>						<p>							<span class="icon-password"></span> <input type="password"								id="password" name="j_password" placeholder="请输入您的密码" />						</p>						 <div >							<select  name="isAdmin" id="isAdmin" class="inputSelect">								<option value="0">店铺管理员</option>								<option value="1">容易管理员</option>															</select>					</div> 			</div>			<table width="100%" border="0" cellspacing="0" cellpadding="0">				<tr>					<td width="20">						<!-- 				<input type="checkbox" name="next" value="checkbox" id="next" /> -->					</td>					<td width="85">						<%--<label name="next" for="next">忘记密码?</label> --%>					</td>				</tr>			</table>			<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0">			  <tr>				<td width="20" height="30">					<input type="checkbox" name="_spring_security_remember_me" value="true" id="_spring_security_remember_me" />				</td>				<td width="100"><label name="_spring_security_remember_me" for="_spring_security_remember_me">记住账号</label></td>				<td>									</td>				<td  width="20">					<input type="checkbox" name="next" value="checkbox" id="next" />				</td>				<td  width="85"><label name="next" for="next">下次自动登录</label></td>			  </tr>		  	</table> -->			<div class="login-button">				<a href="#" onclick="clickLogin();">登录</a>			</div>			</form>		</div>	</div>	</div></body></html>