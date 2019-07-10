<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息页面</title>
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>	


 <div class="layui-row" id="popUpdateTest">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" style="margin-top:20px" >
         
            <div class="layui-form-item">
                <label class="layui-form-label">收件人</label>
                <div class="layui-input-block">
                    <input type="text" name="userName"  required  lay-verify="required" autocomplete="off" value="${order.userName}" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">收件地址</label>
                <div class="layui-input-block">
                    <input type="text" name="address"  required  lay-verify="required" autocomplete="off" value="${order.address}" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">邮编</label>
                <div class="layui-input-block">
                    <input type="text" name="postcode"  required  lay-verify="required" autocomplete="off" value="${order.postcode}"class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-block">
                    <input type="text" name="mobile"  required  lay-verify="required" autocomplete="off" value="${order.mobile}" class="layui-input">
                </div>
            </div>
            
             <div class="layui-form-item">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-block">
                     <select name="orderType">
				       
				        <option value="0" <c:if test="${order.orderType==0}">selected</c:if>>未付款</option>
				        <option value="1" <c:if test="${order.orderType==1}">selected</c:if>>已下单</option>
				        <option value="2" <c:if test="${order.orderType==2}">selected</c:if>>待接收</option>
				        <option value="3" <c:if test="${order.orderType==3}">selected</c:if>>交易成功</option>
				       
      				</select>
                </div>
            </div>
         
            <div class="layui-form-item" style="margin-top:40px">
                <div class="layui-input-block">
                    <button class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="demo1">确认修改</button>
                    
                </div>
            </div>
           
        </form>
    </div>
</div>


<script>
layui.use(['form'], function(){
  var form = layui.form,
  $=layui.jquery;

 
  
  //监听提交
  form.on('submit(demo1)', function(data){
	  
    $.post("updateorder",data.field,function(result){
    	layer.msg("修改成功",{
    		icon:1,
    		time:1000
    	},function(){
    		parent.window.location.reload();
    	});
    })
    
    
    return false;
  });
 
 
  
  
});
</script>








</body>
</html>