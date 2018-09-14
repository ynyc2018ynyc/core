<form id="menuAddForm" method="post">
    <div class="ctjForm">
        <fieldset>
            <legend>基本信息</legend>
        </fieldset>
        <input type="hidden" name="parentId" value="<#if vo??>${vo.id}</#if>"/>
        <div class="ctjRow">
            <label>父菜单名称</label>
            <input class="easyui-textbox" data-options="disabled:true" style="width:590px"
                   value="<#if vo??>${vo.name}</#if>"/>
        </div>
        <div class="ctjRow">
            <label>菜单名称</label>
            <input name="name" class="easyui-textbox" data-options="required: true" style="width:590px"/>
        </div>
        <div class="ctjRow">
            <label>链接地址</label>
            <input name="url" class="easyui-textbox" data-options="" style="width:590px"/><br>
        </div>
        <div class="ctjRow">
            <label>图标名称</label>
            <input name="icon" class="easyui-textbox" data-options="" style="width:590px"/><br>
        </div>
        <div class="ctjRow">
            <label>排序字段</label>
            <input name="sortNum" class="easyui-textbox" data-options="" style="width:590px"/><br>
        </div>
    </div>
</form>