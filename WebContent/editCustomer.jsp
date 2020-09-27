<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- 导入bootStrapcss样式 -->
<link href="/springMvc_6/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<!-- 引入jquery -->
<script type="text/javascript" src="/springMvc_6/js/jquery-1.11.3.min.js"></script>
<!--引入bootStrapjs文件  -->
<script type="text/javascript" src="/springMvc_6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/springMvc_6/js/addAddressInfo.js"></script>

<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="/springMvc_6/jquery/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="/springMvc_6/jquery/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="/springMvc_6/jquery/jquery.datepick.js"></script>
		<script type="text/javascript" src="/springMvc_6/jquery/jquery.datepick-zh-CN.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#custBirthday').datepick({dateFormat: 'yy-mm-dd'}); 
		});
		</script>

</head>
<body>

<div class="container">
	<form role="form" method="post" action="/springMvc_6/cust/api/v_1.0/editCustomerInfo" enctype="multipart/form-data">
  <div class="form-group">
    <input type="hidden"  name="custId"  value="${cust.custId}">
    <label for="exampleInputEmail1">custName</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter custName" name="custName" value="${cust.custName}">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">custSource</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter custSource" name="custSource" value="${cust.custSource}">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">custLevel</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter custLevel" name="custLevel" value="${cust.custLevel}">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">custLinkman</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter custLinkman" name="custLinkman" value="${cust.custLinkman }">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">custPhone</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter custPhone" name="custPhone" value="${cust.custPhone}">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">custMobile</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter custMobile" name="custMobile" value="${cust.custMobile}">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">custBirthday</label>
    <input type="text" class="form-control"  id="custBirthday" placeholder="Enter custBirthday" 
   		 name="custBirthday" readonly="readonly" value='<fmt:formatDate value="${cust.custBirthday}" pattern="yyyy-MM-dd"/>'>
  </div>
  <label for="exampleInputEmail1">address</label>
  <div class="form-group" >
   
		<div class="form-inline col-md-4">
    		<select class="form-control" name="province" onchange="loadCity(this)">
    			<option >&nbsp;&nbsp;${proName } &nbsp;</option>
    		</select>
		  
		 	<select class="form-control" name="city">
		 		<option >&nbsp;&nbsp;${cityName } &nbsp;  </option>	
		 	</select>
  
       </div>
  	<input type="hidden"  name="provinceName" id="provinceName" value=${proName }>
    <input type="text" class="form-control"  placeholder="Enter address" name="address" value="${address}">
  </div>
  
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    
    <c:if test="${cust.picFilepath != null}">
    <img  width="50" height="50" src="/pic/${cust.picFilepath }">
    
    </c:if>
    
    <!--脚下留心： 表单的name属性值不能和对应pojo的属性名称一致 -->
    <input type="file" id="exampleInputFile" name="picFile" >
    
  </div>
  
  <button type="submit" class="btn btn-default">提交</button>
</form>
</div>
</body>
</html>