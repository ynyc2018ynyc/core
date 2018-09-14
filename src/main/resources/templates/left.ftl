<div id="menu" class="easyui-accordion" data-options="fit:true">
    <#list lists as list>
        <div title="${list.name}" data-options="">
            <ul class="easyui-tree" data-options="url:'${basePath}/menu/getTree?pId=${list.id}',
                lines:true,
            	loadFilter: function(rows){return convert(rows);},
                onClick:function(node){
                    var isLeaf = $(this).tree('isLeaf',node.target);
                    if (!isLeaf) {
                        $(this).tree('toggle', node.target);
                    } else {
                        if (node.attributes.url) {
                            refenceCenter(node.attributes.url);
                        }
                    }
                }">
            </ul>
        </div>
    </#list>
</div>