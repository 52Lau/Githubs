<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="${request.contextPath}/faqs2/drop">新增</a>


<table>
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>分类</th>
        <th>时间</th>
    </tr>
    <#list list as a>
    <tr>
        <form action="${request.contextPath}/faqs2/update" method="post">
        <td><input name="id" value="${a.id}" readonly></td>
        <td><input name="title" value="${a.title}" required></td>
        <td><input name="classid" value="${a.classid}" readonly></td>
        <td><input name="createdate" value="${a.createdate}" readonly></td>
        <input type="submit" value="提交">
        </form>
    </tr>
    </#list>
</table>
</body>
</html>