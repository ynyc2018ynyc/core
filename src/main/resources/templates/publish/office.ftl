<html>
<head>
    <#include "../include.ftl">
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        #officeEast .panel-header {
            border-top: 0;
        }
    </style>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="padding:10px; background-color: #F5F5F5;">
    <label for="title">标题：</label>
    <input id="title" class="easyui-textbox" data-options="" style="width:590px"/>
</div>

<div data-options="region:'center'" style="overflow: hidden;">
${pageOffice}
</div>
<div id="officeEast" data-options="region:'east'" style="width:200px;background-color: #F5F5F5;">
    <div class="easyui-panel" data-options="title:'基本信息'" style="width:100%;height:50%;"></div>
    <div class="easyui-panel" data-options="title:'附件上传'" style="width:100%;height:50%;"></div>
</div>
<div data-options="region:'south'" style="padding:10px; background-color: #F5F5F5;">
    <div style="width:1024px;margin:0 auto;text-align: center;">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">保存</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">保存并发布</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    </div>
</div>
</body>
</html>

