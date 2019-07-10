<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息页面</title>
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>	


 <div class="layui-row" id="popUpdateTest">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" action="updateProduct?productId=${productId}" style="margin-top:20px" >
         
            <div class="layui-form-item">
                <label class="layui-form-label">商品名称</label>
                <div class="layui-input-block">
                    <input type="text" name="productName"  required  lay-verify="required" autocomplete="off" value="${product.productName}" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">商品地址</label>
                <div class="layui-input-block">
                    <input type="text" name="productAddress"  required  lay-verify="required" autocomplete="off" value="${product.productAddress}" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">商品描述</label>
                <div class="layui-input-block">
                    <input type="text" name="description"  required  lay-verify="required" autocomplete="off" value="${product.description}"class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">卖价</label>
                <div class="layui-input-block">
                    <input type="text" name="tprice"  required  lay-verify="required" autocomplete="off" value="${product.tprice}" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">活动价</label>
                <div class="layui-input-block">
                    <input type="text" name="fprice"  required  lay-verify="required" autocomplete="off" value="${product.fprice}" class="layui-input">
                </div>
            </div>
               <div class="layui-form-item">
                <label class="layui-form-label">商品类型</label>
                <div class="layui-input-block">
                     <select name="type">
				       
				        <option value="1" <c:if test="${product.type==1}">selected</c:if>>奶粉</option>
				        <option value="2" <c:if test="${product.type==2}">selected</c:if>>营养品</option>
				        <option value="3" <c:if test="${product.type==3}">selected</c:if>>婴儿湿巾</option>
				        <option value="4" <c:if test="${product.type==4}">selected</c:if>>婴儿车</option>
				        <option value="5" <c:if test="${product.type==5}">selected</c:if>>婴儿床</option>
				        <option value="6" <c:if test="${product.type==6}">selected</c:if>>儿童玩具</option>
				        <option value="7" <c:if test="${product.type==7}">selected</c:if>>早教书籍</option>
				        <option value="8" <c:if test="${product.type==8}">selected</c:if>>童装</option>
				        <option value="9" <c:if test="${product.type==9}">selected</c:if>>童鞋</option>
				       
      				</select>
                </div>
            </div>
            
            <div class="layui-form-item">
                <label class="layui-form-label">商品库存</label>
                <div class="layui-input-block">
                    <input type="text" name="stock"  required  lay-verify="required" autocomplete="off" value="${product.stock}" class="layui-input">
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
<!-- <script type="text/javascript">
function change(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
	}

</script> -->


<script>
layui.use(['form'], function(){
  var form = layui.form,
  $=layui.jquery;

 
  
  //监听提交
  form.on('submit(demo1)', function(data){
  
    $.post("updateProduct",data.field,function(result){
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