<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 引入bootstrap文件 -->
<script type="text/javascript" src="${ctx}/static/js/jquery-3.1.0.js"></script>
<link rel="stylesheet" href="${ctx }/static/js/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx }/static/js/bootstrap/js/bootstrap.min.js"></script>

<!-- 打印错误信息 -->
<script type="text/javascript">
var message=${message!}+"";
if(message !=null && message!=undefined && message!="" ){
	alert(message);
}
</script>
<!-- 把表格数据封装成JSON格式，封装成一个集合传到后台 -->
<script type="text/javascript">

function jsonTest(){
var pvs = [];
var rows=document.getElementById("tableList").rows.length;
var colums=colums = document.getElementById("tableList").rows[0].cells.length;
//alert("rows:"+rows);
//alert("colums:"+colums);
if(rows>=1){
	for(var i=0;i<rows-1;i++){
		var propertyValue={value:"",pp_uuid:"",pd_uuid:""};
		//第一个子节点是隐藏的Ttable
		propertyValue.value=document.getElementById("tableList").children[0].children[i].children[1].children[0].value;
		propertyValue.pp_uuid=document.getElementById("tableList").children[0].children[i].children[1].children[0].id;
		propertyValue.pd_uuid=document.getElementById("pd_uuid").value;
		pvs.push(propertyValue);
	}	
}
//pvs={value:"lihao",pp_uuid:"dgg22",pd_uuid:"d22dd"}
//alert(JSON.stringify(pvs));
if(pvs!==null){
	$.ajax({
	url:"${ctx}/pvc/add",
	type:"post",
	contentType:"application/json;charset=utf-8",
	//dataType:"json",
	data:JSON.stringify(pvs),
	success:function(data){
		alert("成功添加"+data.result+"属性");
		
	},
	error:function(res){
		alert("后台出现错误！");
		//alert(res.responseText);
	}
	
	})
	
}

}
</script>

<!-- ajax网上找来的范例 -->
<script type="text/javascript" language="JavaScript">
function submitUserList_3() {alert("ok");
    var customerArray = new Array();
    customerArray.push({id: "1", name: "李四", pwd: "123"});
    customerArray.push({id: "2", name: "张三", pwd: "332"});
    $.ajax({
        url: "/user/submitUserList_3",
        type: "POST",
        contentType : 'application/json;charset=utf-8', //设置请求头信息
        dataType:"json",
        //data: JSON.stringify(customerArray),    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
        data: $.toJSON(customerArray),            //将Json对象序列化成Json字符串，toJSON()需要引用jquery.json.min.js
        success: function(data){
            alert(data.responseText);
        },
        error: function(res){
            alert(res.responseText);
        }
    });
}


</script>
</head>
<body>
<form  >
<table class="table table-hover" id="tableList">
<#list propertys as property>
<tr>
<td>${property?if_exists.name}</td>
<td><input name="${property?if_exists.name}" id="${property?if_exists.uuid}"/></td>
</tr>

</#list>
<tr>
<td><input type="submit" value="submit" onclick="jsonTest()"/> <button type="button" value="submit" onclick="jsonTest()">test</button></td><td><input type="hidden" id="pd_uuid" value="${pd_uuid}"></input></td>
</tr>
</table>


</form>


</body>
</html>