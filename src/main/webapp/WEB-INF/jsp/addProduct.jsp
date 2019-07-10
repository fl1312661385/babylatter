<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品页面</title>
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<style>
.img{
	width:150px;
	height:90px;
}
.select{
	display:none;
}

</style>

<script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>	


 <div class="layui-row" id="popUpdateTest">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" method="post" enctype="multipart/form-data" style="margin-top:20px" action="insertProduct">
         
            <div class="layui-form-item">
                <label class="layui-form-label">商品名称</label>
                <div class="layui-input-block">
                    <input type="text" name="productName"  required  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">商品地址</label>
                <div class="layui-input-block">
                    <input type="text" name="productAddress"  required  lay-verify="required" autocomplete="off"  class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">商品描述</label>
                <div class="layui-input-block">
                    <input type="text" name="description"  required  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">卖价</label>
                <div class="layui-input-block">
                    <input type="text" name="tprice"  required  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">活动价</label>
                <div class="layui-input-block">
                    <input type="text" name="fprice"  required  lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
               <div class="layui-form-item">
                <label class="layui-form-label">商品类型</label>
                <div class="layui-input-block">
                     <select name="type">
				       
				        <option value="1" selected>奶粉</option>
				        <option value="2" >营养品</option>
				        <option value="3" >婴儿湿巾</option>
				        <option value="4" >婴儿车</option>
				        <option value="5" >婴儿床</option>
				        <option value="6" >儿童玩具</option>
				        <option value="7" >早教书籍</option>
				        <option value="8" >童装</option>
				        <option value="9" >童鞋</option>
				       
      				</select>
                </div>
            </div>
            
            <div class="layui-form-item">
                <label class="layui-form-label">商品库存</label>
                <div class="layui-input-block">
                    <input type="text" name="stock"  required  lay-verify="required" autocomplete="off"  class="layui-input">
                </div>
            </div>
			<div class="layui-form-item">
                <label class="layui-form-label">商品图片</label>
                
               <input type="file" id="loadfile" class="imgInput layui-inline layui-word-aux" name="upfile" value="上传图片"/>
                <img src="" class="img select">
			<span class="quxiao select layui-btn layui-btn-primary">取消</span>
    		</div>
           
            
            <div class="layui-form-item" style="margin-top:40px">
                <div class="layui-input-block">
                    <button class="layui-btn  layui-btn-submit " type="submit">确认</button>
                    
                </div>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">

layui.use('form', function(){
	var form = layui.form; //只有执行了这一步，部分表单元素才会修饰成功 
	});
</script>

<script>
$(function(){
	$(".imgInput").change(function(){
		$(".img").removeClass("select");
		$(".quxiao").removeClass("select");
	    $(".img").attr("src",URL.createObjectURL($(this)[0].files[0]));
	});
	$(".quxiao").click(function(){
		$(".img").addClass("select");
		$(".quxiao").addClass("select");
	})
})
	

</script>








</body>
</html>