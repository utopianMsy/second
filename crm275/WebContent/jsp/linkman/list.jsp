<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();	
	}
</SCRIPT>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<s:debug></s:debug>
	<FORM id="customerForm" name="customerForm" action="${pageContext.request.contextPath }/linkman_findAll.action" method=post>		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg" height=20></TD>
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
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>联系人名称：</TD>
													<TD><INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="lkmName"></TD>
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
													<TD><INPUT class=button id=sButton2 type=submit value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=grid style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>职位</TD>
													<TD>备注</TD>
													<TD>所属客户</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${rowsData }" var="linkman">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${linkman.lkmName }</TD>
													<TD>${linkman.lkmGender }</TD>
													<TD>${linkman.lkmPhone }</TD>
													<TD>${linkman.lkmMobile }</TD>
													<TD>${linkman.lkmEmail }</TD>
													<TD>${linkman.lkmPosition }</TD>
													<TD>${linkman.lkmMemo }</TD>
													<TD>${linkman.customer.custName}</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/linkman_toEditPage.action?lkmId=${linkman.lkmId}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/linkman_deleteLinkman.action?lkmId=${linkman.lkmId}">删除</a>
													</TD>
												</TR>
												</c:forEach>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<tr>
									<td>
										<a href="javascript:toPage(${prePage })">上一页</a>
										&nbsp;
										<c:forEach begin="${beginPage }" end="${endPage }" var="v">
											<a href="javascript:toPage(${v })">${v }</a>
										</c:forEach>
										&nbsp;
										<a href="javascript:toPage(${nextPage })">下一页</a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										显示<input name="rowsNum" value="${rowsNum }">条记录
										<input value="go" onclick="toPage()" type="button">
										共${pageNum }页
										<input type="hidden" name="page" id="cPage">
										<script type="text/javascript">
											function toPage(currentPage){
												//给隐藏input赋要跳转的页码值
												$("#cPage").val(currentPage);
												//提交表单
												$("#customerForm").submit();
											}
										</script>
									</td>
								</tr>
							</TBODY>
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
