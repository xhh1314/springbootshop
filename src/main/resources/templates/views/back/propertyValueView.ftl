<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<#assign ctx=request.contextPath />
<head>
<link rel="stylesheet" href="${ctx}/semantic/semantic.min.css">
<script src="${ctx}/semantic/semantic.min.js"> </script>
<script type="text/javascript" src="${ctx}/static/js/jquery-3.1.0.js"></script>
<style type="text/css">
.myTable {
	width: 1000px;
	margin: 0px auto;
}
</style>
<script type="text/javascript">
var currentPage=${page?if_exists.currentPage};
var beginPage=${page?if_exists.beginPage};
var endPage=${page?if_exists.endPage};
var totalPage=${page?if_exists.totalPage};
function initial(){
for(var i=beginPage;i<=endPage;i++){
var a=document.createElement("a");
a.href="${ctx}/pvc/current?currentPage="+i+"&beginPage="+beginPage+"&endPage="+endPage;
a.innerHTML=i;
a.classname="item";
$("#pageNext").before(a);
}

if(beginPage==1)
$("#pagePrevious").attr('disabled',true);

if(endPage==totalPage)
	$("#pageNext").atrr('disabled',true);
}
//下一页
function pageNext(){
	document.location.href="${ctx}/pvc/next?currentPage="+currentPage+"&beginPage="+beginPage+"&endPage="+endPage;
	}
//上一页
	function pagePrevious(){
		document.location.href="${ctx}/pvc/previous?currentPage="+currentPage+"&beginPage="+beginPage+"&endPage="+endPage;
		}
</script>
</head>
<body onload="initial()">
	<div class="myTable">
		<table class="ui celled table">
			<thead>
				<tr>
					<th>序号</th>
					<th>值</th>
					<th>所属产品</th>
				</tr>
			</thead>
			<tbody>
				<#list propertyValues?if_exists as pv>
				<tr>
					<td>
						<div class="ui ribbon label">${pv.pvid}</div>
					</td>
					<td>${pv.propertyValue}</td>
					<td>${pv.productName}</td>
				</tr>
				</#list>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3">
						<div class="ui right floated pagination menu">
							<a class="icon item" id="pagePrevious" onclick="pagePrevious()"> 
							<i class="left chevron icon"></i>
							</a>
							 <a class="icon item" id="pageNext" onclick="pageNext()">
								<i class="right chevron icon"></i>
							</a>
						</div>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>

</html>