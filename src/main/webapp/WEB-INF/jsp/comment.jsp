<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>评论界面</title>
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	
</head>
<body class="childrenBody">
<div class="demoTable">
  搜索评论：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="请输入商品或者评论人">
  </div>
  <button class="layui-btn" data-type="reload" id="search">搜索</button>
</div>
 
<script type="text/html" id="barDemo">

  <a class="layui-btn layui-btn-xs" lay-event="editComment">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delComment">删除</a>
</script>
	<table id="demo" lay-filter="test"></table>
	<div id="demo1"></div>
<!-- 	<div id="page"></div> -->
	<script type="text/javascript" src="layui/layui.js"></script>
	
	
	
	<script>
		layui.use(['table','laypage'], function(){
		  var table = layui.table;
		  var laypage = layui.laypage;  
		  //第一个实例
		  var tableIns=table.render({
		    elem: '#demo'
		    ,height: 500
		    ,url: 'commentData' //数据接口
		    ,page: true //开启分页
		    ,id:'commenttable'
		  	,cols: [[ //表头
		            {field: 'commentId', title: 'ID', width:80, sort: true, fixed: 'left'}
		            ,{field: 'replyName', title: '回复者', width:80, align: 'center'}
		            ,{field: 'commentName', title: '评论者', width:80, align: 'center'}
		            ,{field: 'productName', title: '评论商品', width:100, align: 'center'}
		            ,{field: 'content', title: '评论内容', width:200, align: 'center'} 
		            ,{field: 'commentDate', title: '评论日期', width: 180, align: 'center'}
		            ,{field: 'commentTime', title: '评论时间', width: 100, align: 'center'}
		            ,{field: 'state', title: '状态', width: 80, align: 'center'}   
		            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:170, align: 'center'}
		          ]]
		  
		  });
		 
		  table.on('tool(test)', function(obj){
			    var data = obj.data;
			    var $ = layui.$;
			    var layer = layui.layer;
			    //console.log(obj)
			 if(obj.event === 'editComment'){
			    	 var layer = layui.layer;
			    	 layer.open({
			    		 type:2,
			    		 title:'评论编辑',
			    		 
			    		 area: ['500px', '500px'],
			    		 content:'editComment?commentId='+data.commentId,
			    		 end:function(){
			    			 location.reload();
			    		 }
			    		 
			    	 })
			   
			    
			    
			    }else if(obj.event === 'delComment'){
			    	  layer.confirm('确认删除吗？', function(index){
					        obj.del();
					        layer.close(index);
					        console.log(data);
					        $.ajax({
		                        url: "delComment",
		                        type: "post",
		                        data:{"commentId":data.commentId},
		                        dataType: "json",
		                        success: function(data){
		                        	if(data==1){

		                               
		                                layer.msg("删除成功", {icon: 6});
			                         	table.reload('commenttable');
		                            }else{
		                                layer.msg("删除失败", {icon: 5});
		                                table.reload('commenttable');
		                            }
		                        	
		                        }

		                    });
					      });
			    	
			    }
			    
			    
			    
			  });
		  
		  var $ = layui.$;
		  $('#search').on('click', function(){
			  var demoReload = $('#demoReload');
		      table.reload('commenttable', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		        
		        	replyName: demoReload.val()
		        	
		        
		        }
		      });
			  });
		});

</script>
	
	
	
	
	
</body>
</html>