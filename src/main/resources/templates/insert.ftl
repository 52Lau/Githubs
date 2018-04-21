<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${request.contextPath}/faqs2/insert" method="post">
    <select name="classid">
        <#list list as a>
            <option value="${a.id}">${a.cname}</option>
        </#list>
    </select>
    <input name="title" value="搜索">
    <input name="content" value="事实上">
    <input type="submit" value="提交">
</form>
</body>
</html>