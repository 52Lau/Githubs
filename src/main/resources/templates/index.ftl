<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="${request.contextPath}/faqs2/drop">新增</a>

<form action="${request.contextPath}/faqs2/index" method="post">
    标题:<input name="title"><br>
    <input type="submit" value="查询">
</form>
<table>
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>分类</th>
        <th>时间</th>
        <th>操作</th>
    </tr>
    <#list pageInfo.list as list>
    <tr>
        <td>${list.id}</td>
        <td>${list.title}</td>
        <td>${list.classes.cname}</td>
        <td>${list.createdate}</td>
        <td><a href="${request.contextPath}/faqs2/delete?id=${list.id}">删除</a>
            <a href="${request.contextPath}/faqs2/upDrop?id=${list.id}">修改</a>
        </td>
    </tr>
    </#list>
</table>
<a href="${request.contextPath}/faqs2/index?page=${pageInfo.firstPage}">首页</a>
<a href="${request.contextPath}/faqs2/index?page=${pageInfo.nextPage}">下页</a>
<a href="${request.contextPath}/faqs2/index?page=${pageInfo.prePage}">上页</a>
<a href="${request.contextPath}/faqs2/index?page=${pageInfo.lastPage}">尾页</a>
</body>
</html>