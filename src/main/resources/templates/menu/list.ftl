<div id="menu" class="easyui-panel" data-options="fit:true,title:'菜单管理'">
    <div id="menuList" class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false,collapsible:false"
             style="width:270px; padding:3px;border-top:0;border-left:0;border-bottom: 0;">
            <ul id="menuTree" class="easyui-tree" data-options="url:'${basePath}/menu/getTreeAll',
                lines:true,
            	loadFilter: function(rows){return convert(rows);},
                onClick:function(node){
                    refresh_menuGrid(node.id);
                }">
            </ul>
        </div>
        <div data-options="region:'center'"
             style="border-top:0;border-right:0;border-bottom: 0;padding:3px;">
            <table id="menuGrid" class="easyui-datagrid"
                   data-options="fit:true,fitColumns:true,singleSelect:true,rownumbers:true,pagination:true,
                        toolbar:'#menu_tb',url:'${basePath}/menu/getChild'">
                <thead>
                <tr>
                    <th data-options="field:'name',width:100">名称</th>
                    <th data-options="field:'url',width:100">链接地址</th>
                    <th data-options="field:'icon',width:100">图标</th>
                    <th data-options="field:'type',width:100">菜单类型</th>
                    <th data-options="field:'sortNum',width:100">排序字段</th>
                    <th data-options="field:'creTime',width:100">创建时间</th>
                </tr>
                </thead>
            </table>
        </div>
        <div id="menu_tb" style="padding:5px 10px;">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
               onclick="javascript:menuAdd();">新增</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
        </div>
    </div>
</div>

<script type="text/javascript">
    var pid = "root";

    function refresh_menuGrid(pId) {
        var url = "${basePath}/menu/getChild?pId=" + pId;
        pid = pId;
        $("#menuGrid").datagrid({url: url});
    }

    function refresh_menuTree() {
        $("#menuTree").tree("reload");
    }

    function menuAdd() {
        var _dlg = showDialog({title: '新增菜单', iconCls: 'icon-add', href: '${basePath}/menu/toAdd?pId=' + pid},
                function () {
                    $("#menuAddForm").form('submit', {
                        url: "${basePath}/menu/add",
                        onSubmit: function () {
                            var validate = $(this).form("validate");
                            return validate;
                        },
                        success: function (d) {
                            var data = $.parseJSON(d);
                            if (data.status === "success") {
                                console.log("成功");
                                $.messager.alert('提示', '保存成功！', 'info',function(){
                                    _dlg.dialog("destroy");
                                    refresh_menuGrid(pid);
                                    refresh_menuTree();
                            });
                            } else {
                                $.messager.alert('提示', '保存失败！', 'warning');
                            }
                        }
                    })
                });
    }
</script>