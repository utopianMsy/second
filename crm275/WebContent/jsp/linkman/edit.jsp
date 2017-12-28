<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/linkman_edit.action" method=post>
		<input type="hidden" name="lkmId" value="${lkmId }">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"  height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 修改联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>所属客户：</td>
								<td colspan="3">
									<select name="customer.custId" style="WIDTH: 180px" id="selectBtn">
										<option value="">--请选择--</option>
										<script type="text/javascript">
											$(function(){
												//页面加载完成后发送ajax请求到后台获取到客户集合
												$.post("${pageContext.request.contextPath }/customer_findCustomers.action", function(data){
													/* $(data).each(function(i, r){
														$("#selectBtn").append('<option value="'+r.custId+'">'+r.custName+'</option>');
														//alert('${customer.custId}');
														$("#selectBtn option[value='${customer.custId}']").attr("selected",true);
													})  */
													for(var i=0;i<data.length;i++){
														$("#selectBtn").append('<option value="'+data[i].custId+'">'+data[i].custName+'</option>');
														//判断当前option的value值是否等于值栈中customer.custId一直，如果一直选中
														$("#selectBtn option[value=${customer.custId}]").attr("selected",true);
													} 
												});
											});
										</script>
									</select>
								</td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkmName" value="${lkmName }">
								</td>
								<td>联系人性别：</td>
								<td>
									<input type="radio" value="1" name="lkmGender" <c:if test="${lkmGender==1 }">checked=true</c:if>>男
									<input type="radio" value="2" name="lkmGender" <c:if test="${lkmGender==2 }">checked=true</c:if>>女
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkmPhone" value="${lkmPhone}">
								</td>
								<td>联系人手机 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkmMobile" value="${lkmMobile}">
								</td>
							</TR>
							<TR>
								<td>联系人邮箱 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkmEmail" value="${lkmEmail}">
								</td>
								<td>联系人职位 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="lkmPosition" value="${lkmPosition}">
								</td>
							</TR>
							<TR>
								<td>联系人简介 ：</td>
								<td colspan="2">
									<textarea class=textbox id=sChannel2 style="WIDTH: 180px"  name="lkmMemo">${lkmPhone}</textarea>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
									<INPUT class=button id=sButton2 type=submit value="保存 ">
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg" border=0></TD>
					<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
