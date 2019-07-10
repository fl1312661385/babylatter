<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>订单界面</title>
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	
</head>
<body class="childrenBody">
<div class="demoTable">
  搜索订单：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" id="search">搜索</button>
</div>
 
<script type="text/html" id="barDemo">
 {{#  if(d.orderType === 1){ }}
	     <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="sendgoods">发货</a>
  <a class="layui-btn layui-btn-xs" lay-event="editorder">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	  {{#  } }} 

 {{#  if(d.orderType === 2){ }}
  <a class="layui-btn layui-btn-xs" lay-event="editorder">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	  {{#  } }} 
{{#  if(d.orderType === 3){ }}
  <a class="layui-btn layui-btn-xs" lay-event="editorder">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	  {{#  } }} 
 
</script>
	<table id="demo" lay-filter="test"></table>
	<div id="demo1"></div>
<!-- 	<div id="page"></div> -->
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" id="changeshow">
	 {{#  if(d.orderType === 0){ }}
	    待付款
	  {{#  } }} 
	 {{#  if(d.orderType === 1){ }}
	    已付款
	  {{#  } }} 
	
	 {{#  if(d.orderType === 2){ }}
	    已发货
	  {{#  } }}
	 {{#  if(d.orderType === 3){ }}
	    交易成功
	  {{#  } }}
	</script>
	
	
	<script>
		layui.use(['table','laypage'], function(){
		  var table = layui.table;
		  var laypage = layui.laypage;  
		  //第一个实例
		  var tableIns=table.render({
		    elem: '#demo'
		    ,height: 500
		    ,url: 'orderData' //数据接口
		    ,page: true //开启分页
		    ,id:'ordertable'
		  	,cols: [[ //表头
		            {field: 'orderId', title: 'ID', width:50, sort: true, fixed: 'left'}
		            ,{field: 'userName', title: '收件人', width:80, align: 'center'}
		            ,{field: 'address', title: '收件地址', width:160, align: 'center'}
		            ,{field: 'postcode', title: '邮编', width:100, align: 'center'} 
		            ,{field: 'mobile', title: '电话', width: 100, align: 'center'}
		            ,{field: 'productName', title: '商品名称', width: 80, align: 'center'}
		            ,{field: 'quantity', title: '数量', width: 80, align: 'center'}
		          
		            ,{field: 'orderPrice', title: '价格', width: 100, align: 'center'}
		            ,{field: 'orderCode', title: '订单编号', width: 120, align: 'center'}
		            ,{field: 'orderType', title: '状态', width: 100, align: 'center',templet: '#changeshow'}
		            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:170, align: 'center'}
		          ]]
		  
		  });
		 
		  table.on('tool(test)', function(obj){
			    var data = obj.data;
			    var $ = layui.$;
			    var layer = layui.layer;
			    //console.log(obj)
			    if(obj.event === 'sendgoods'){
			      layer.confirm('确认发货吗？', function(index){
			        obj.del();
			        layer.close(index);
			        console.log(data);
			        $.ajax({
                        url: "sendgoods",
                        type: "post",
                        data:{"orderId":data.orderId},
                        dataType: "json",
                        success: function(data){
                        	layer.msg("成功发货", {icon: 6});
                         	table.reload('ordertable')
                        }

                    });
			      });
			    } else if(obj.event === 'editorder'){
			    	 var layer = layui.layer;
			    	 layer.open({
			    		 type:2,
			    		 title:'订单编辑',
			    		 area: ['500px', '500px'],
			    		 content:'editorder?orderId='+data.orderId,
			    		 end:function(){
			    			 location.reload();
			    		 }
			    		 
			    	 })
			   
			    
			    
			    }else if(obj.event === 'del'){
			    	  layer.confirm('确认删除吗？', function(index){
					        obj.del();
					        layer.close(index);
					        console.log(data);
					        $.ajax({
		                        url: "delorder",
		                        type: "post",
		                        data:{"orderId":data.orderId},
		                        dataType: "json",
		                        success: function(data){
		                        	layer.msg("删除成功", {icon: 6});
		                         	table.reload('ordertable')
		                        }

		                    });
					      });
			    	
			    }
			    
			    
			    
			  });
		  
		  var $ = layui.$;
		  $('#search').on('click', function(){
			  var demoReload = $('#demoReload');
		      table.reload('ordertable', {
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