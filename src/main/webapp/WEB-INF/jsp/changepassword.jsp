<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
<div>
<br>
</div>
				<form class="layui-form" action="editpassword">
				  	<div class="layui-form-item">
					    <label class="layui-form-label">旧密码</label>
					    <div class="layui-input-inline">
					      <input type="password" name="password" required lay-verify="required" placeholder="请输入旧密码" autocomplete="off" class="layui-input">
					    </div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label">新密码</label>
					    <div class="layui-input-inline">
					      <input type="password" name="newpassword" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
					    </div>
					   </div> 
				    <div class="layui-form-item">
				    <label class="layui-form-label">确认密码</label>
				    <div class="layui-input-inline">
				      <input type="password" name="orderpassword" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
				    </div>
				   
				  </div>
				  <div class="layui-table-btn" >
						<button class="layui-btn" style="margin-left:110px" type="submit" onclick="check()">确 定</button>
						<button class="layui-btn layui-btn-primary cancel" type="reset" style="margin-left:50px" >取 消</button>
					</div>
				</form>
				
				<script type="text/javascript">
				function check() {
				    var password=password.value;
				    var newpassword=newpassword.value;
				    var orderpassword=orderpassword.value;
				    if((password=="")){//判断用户名是否为空，为空就弹出提示框"请输入用户名"，否则正常执行下面的代码。
				        alert("请输入旧密码");
				        password.focus();//获取焦点，即：鼠标自动定位到用户名输入框，等待用户输入用户名。
				        return;
				    }
				    else if((newpassword=="")){//判断密码是否为空，为空就弹出提示框"请输入密码"，否则正常执行下面的代码。
				        alert("请输入新密码！");
				        newpassword.focus();//获取焦点。
				        return;}
				    else if((orderpassword=="")){//如果用户名、密码都正常输入，则提交表单，浏览器经打开新的（主页）窗口。
				    	alert("请确认新密码！");
				        orderpassword.focus();//获取焦点。
				        return;
				    }else(newpassword!=orderpassword){
				    	alert("新密码不一致");
				    	return；
				    }
				}
				</script>
		
</body>
</html>