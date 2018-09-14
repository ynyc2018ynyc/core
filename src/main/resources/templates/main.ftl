<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title>门户系统</title>
    <#include "include.ftl">
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false,href:'${basePath}/menu/toTop'"
     style="height:64px; background:#3C8DBC;">
</div>
<div id="west" data-options="region:'west',iconCls:'icon-reload',split:true,href:'/menu/toLeft?parentId=1'"
     style="width:270px; padding:3px;">
</div>
<div id="center" data-options="region:'center'" style="padding:3px;"></div>
</body>
</html>