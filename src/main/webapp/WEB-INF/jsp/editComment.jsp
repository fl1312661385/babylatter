<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论信息页面</title>
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>	


 <div class="layui-row" id="popUpdateTest">
    <div class="layui-col-md10">
        
         
            <div class="layui-form-item">
                <label class="layui-form-label">回复者</label>
                <div class="layui-input-block">
                    <input type="text"  disabled="disabled" required  lay-verify="required" autocomplete="off" value="${comment.replyName}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">评论者</label>
                <div class="layui-input-block">
                    <input type="text"  disabled="disabled" required  lay-verify="required" autocomplete="off" value="${comment.commentName}" class="layui-input">
                </div>
            </div>
             <div class="layui-form-item">
                <label class="layui-form-label">评论商品</label>
                <div class="layui-input-block">
                    <input type="text"  disabled="disabled" required  lay-verify="required" autocomplete="off" value="${comment.productName}" class="layui-input">
                </div>
            </div>
          <form class="layui-form" action="">
			  <div class="layui-form-item">
			    <label class="layui-form-label">评论内容</label>
			    <div class="layui-input-block">
			      <input type="text" name="content" id="content" value="${comment.content}" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
			    </div>
			  </div>
			 <div class="layui-form-item">
			    <label class="layui-form-label">评论日期</label>
			    <div class="layui-input-block">
			      <input type="text" name="commentDate" id="commentDate" value="${comment.commentDate}"  lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">评论时间</label>
			    <div class="layui-input-block">
			      <input type="text" name="commentTime" id="commentTime" value="${comment.commentTime}"  lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">评论状态</label>
			    <div class="layui-input-block">
			      <input type="text" name="state" id="state" value="${comment.state}"  lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
			    </div>
			  </div>
			  
            <div class="layui-form-item" style="margin-top:40px">
                <div class="layui-input-block">
                   
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">确认修改</button>
                    
                </div>
            </div>
</form>
    </div>
</div>

<!-- <script type="text/javascript">

function change(){
	
	console.log("123");
	
	 $.ajax({
         url:'updateComment',
         type:'post',
         dataType:'json',
         data:$("#addform").serialize(),
         success:function(result){
             //回调函数
        	console.log("成功了");
        	 var index = parent.layer.getFrameIndex(window.name);
     		parent.layer.close(index);
     	
         }

     });

	
}

</script> -->
<script>
layui.use(['form'], function(){
  var form = layui.form,
  $=layui.jquery;

 
  
  //监听提交
  form.on('submit(demo1)', function(data){
   /*  layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    }) */
    $.post("updateComment",data.field,function(result){
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
<script type="text/javascript">

layui.use(['laydate'], function(){
	var form = layui.form; //只有执行了这一步，部分表单元素才会修饰成功 
	var laydate = layui.laydate;
	  
	  //常规用法
	  laydate.render({
	    elem: '#commentDate'
	  });
	  laydate.render({
		    elem: '#commentTime'
		    ,type: 'time'
		  });
		  
	
	})
</script>









</body>
</html>