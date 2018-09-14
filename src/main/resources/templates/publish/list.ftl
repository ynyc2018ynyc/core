<div id="publish" class="easyui-panel" data-options="fit:true,title:'发布管理'"
     style="border:0;">
    <table class="easyui-datagrid" id="publishList" style=""
           data-options="fitColumns:true,singleSelect:true,fit:true,toolbar:'#publish_tb',rownumbers:true,pagination:true">
        <thead>
        <tr>
            <th data-options="field:'code',width:100">编码</th>
            <th data-options="field:'name',width:100">名称</th>
            <th data-options="field:'price',width:100,align:'right'">价格</th>
        </tr>
        </thead>
    </table>
</div>
<div id="publish_tb" style="padding:5px 10px;">
<#--javascript:POBrowser.openWindowModeless( "Word.jsp?id=12","width=800px;height=800px;")-->
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="javascript:openOffice();">新增</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
</div>

<script type="text/javascript">
    function openOffice() {
        var h = window.screen.availHeight;
        var w = window.screen.availWidth;
        POBrowser.openWindowModeless('${basePath}/publish/toOffice', 'width=' + w + "px;height=" + h + "px;")
    }
</script>