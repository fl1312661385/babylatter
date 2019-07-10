<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>后台用户界面</title>
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	
</head>
<body class="childrenBody">
<div class="demoTable">
  搜索后台用户：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" id="search">搜索</button>
</div>
 
<script type="text/html" id="barDemo">
{{#  if(d.useType === 0){ }}
      <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">禁用</a>
  {{#  } }}
 {{#  if(d.useType === 1){ }}
      <a class="layui-btn layui-btn-sm" lay-event="edit">启用</a>
  {{#  } }}
</script>
	<table id="demo" lay-filter="test"></table>
	<div id="demo1"></div>
<!-- 	<div id="page"></div> -->
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" id="changeshow">
	
	{{#  if(d.useType === 0){ }}
    启用中
  {{#  } }} 
 {{#  if(d.useType === 1){ }}
    禁用中
  {{#  } }} 
	</script>
	<script>
		layui.use(['table','laypage'], function(){
		  var table = layui.table;
		  var laypage = layui.laypage;  
		  //第一个实例
		  table.render({
		    elem: '#demo'
		    ,height: 350
		    ,url: 'latteruserDate' //数据接口
		    ,page: true //开启分页
		    ,id:'usertable'
		  	,cols: [[ //表头
		            {field: 'userId', title: 'ID', width:80, sort: true, fixed: 'left'}
		            ,{field: 'userName', title: '用户名', width:80, align: 'center'}
		            ,{field: 'loginName', title: '电话号码', width:180, align: 'center'}
		            ,{field: 'password', title: '密码', width: 80, align: 'center'}
		            ,{field: 'useType', title: '状态', width: 80, align: 'center',templet:'#changeshow'}
		            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150, align: 'center'}
		          ]]
		  
		  });
		 
		  table.on('tool(test)', function(obj){
			    var data = obj.data;
			    var $ = layui.$;
			    //console.log(obj)
			    if(obj.event === 'del'){
			      layer.confirm('真的禁用次用户吗？', function(index){
			      
			        layer.close(index);
			       
			        $.ajax({
                        url: "deletelUser",
                        type: "post",
                        data:{"userId":data.userId},
                        dataType: "json",
                        success: function(data){
                        	console.log(data);
                        	layer.msg("禁用成功", {icon: 6});
                        	table.reload('usertable')
                        }

                    });
			      });
			    } else if(obj.event === 'edit'){

				      layer.confirm('真的启用此用户吗？', function(index){
				     
				        layer.close(index);
				      
				        $.ajax({
	                        url: "enablelUser",
	                        type: "post",
	                        data:{"userId":data.userId},
	                        dataType: "json",
	                        success: function(data){
	                        	console.log(data);
	                        	layer.msg("启用成功", {icon: 6});
	                        	table.reload('usertable')
	                        }

	                    });
				      });
			     
			    }
			  });
		  
		  var $ = layui.$;
		  $('#search').on('click', function(){
			  var demoReload = $('#demoReload');
		      table.reload('usertable', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		        
		            userName: demoReload.val()
		        
		        }
		      });
			  });
		});

</script>
	
	
	
	
	
</body>
</html>