<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>下架商品界面</title>
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<style type="text/css">
	.layui-table-cell{
    height:95px;
    line-height: 95px;
}
	</style>
</head>
<body class="childrenBody">
<div class="demoTable">
  搜索商品：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" id="search">搜索</button>
</div>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="onproduct">上架</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	<table id="demo" lay-filter="test"></table>
	<div id="demo1"></div>
<!-- 	<div id="page"></div> -->
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" id="changeshow">
	已下架
		
	</script>
	
	
	<script>
		layui.use(['table','laypage'], function(){
		  var table = layui.table;
		  var laypage = layui.laypage;  
		  //第一个实例
		  table.render({
		    elem: '#demo'
		    ,height: 500
		    ,url: 'underProductData' //数据接口
		    ,page: true //开启分页
		    ,id:'producttable'
		  	,cols: [[ //表头
		            {field: 'productId', title: 'ID', width:80, sort: true, fixed: 'left'}
		            ,{field: 'productName', title: '商品名称', width:100, align: 'center'}
		            ,{field: 'productImg', title: '商品图片', width:130, align: 'left',templet:'<div><img src="http://ps95majwc.bkt.clouddn.com/{{d.productImg}}"  width="150px" height="90px" /></div>'}
		            ,{field: 'description', title: '描述', width:180, align: 'center'}
		            ,{field: 'productAddress', title: '地址', width:100, align: 'center'} 
		            ,{field: 'tprice', title: '卖价', width: 80, align: 'center'}
		            ,{field: 'fprice', title: '活动价', width: 80, align: 'center'}
		            ,{field: 'stock', title: '库存', width: 80, align: 'center'}
		          
		            ,{field: 'show', title: '状态', width: 100, align: 'center',templet:'#changeshow'}
		            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:180, align: 'center'}
		          ]]
		  
		  });
		 
		  table.on('tool(test)', function(obj){
			    var data = obj.data;
			    var $ = layui.$;
			    var layer = layui.layer;
			    //console.log(obj)
			    if(obj.event === 'onproduct'){
			      layer.confirm('确认上架商品吗？', function(index){
			        obj.del();
			        layer.close(index);
			        console.log(data);
			        $.ajax({
                        url: "onproduct",
                        type: "post",
                        data:{"productId":data.productId},
                        dataType: "json",
                        success: function(data){
                        	
                        	layer.msg("上架成功", {icon: 6});
                        	table.reload('producttable')
                         
                        }

                    });
			      });
			    } else if(obj.event === 'edit'){
			    	 var layer = layui.layer;
			    	 layer.open({
			    		 type:2,
			    		 title:'商品编辑',
			    		 
			    		 area: ['500px', '500px'],
			    		 content:'editproduct?productId='+data.productId,
			    		 end:function(){
			    			 location.reload();
			    		 }
			    		 
			    	 })
			   
			    
			    
			    }
			    
			    
			    
			  });
		  
		  var $ = layui.$;
		  $('#search').on('click', function(){
			  var demoReload = $('#demoReload');
		      table.reload('producttable', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		        
		        	productName: demoReload.val()
		        
		        }
		      });
			  });
		});

</script>
	
	
	
	
	
</body>
</html>