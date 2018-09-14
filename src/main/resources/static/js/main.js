function convert(rows) {
    function exists(rows, parentId) {
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].id === parentId) return true;
        }
        return false;
    }

    var nodes = [];
    // get the top level nodes
    for (var i = 0; i < rows.length; i++) {
        var row = rows[i];
        if (!exists(rows, row.parentId)) {
            nodes.push({
                id: row.id,
                text: row.name,
                attributes: {url: row.url, icon: row.icon}
            });
        }
    }

    var toDo = [];
    for (var i = 0; i < nodes.length; i++) {
        toDo.push(nodes[i]);
    }
    while (toDo.length) {
        var node = toDo.shift();	// the parent node
        // get the children nodes
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i];
            if (row.parentId === node.id) {
                var child = {id: row.id, text: row.name, attributes: {url: row.url, icon: row.icon}};
                if (node.children) {
                    node.children.push(child);
                } else {
                    node.children = [child];
                }
                toDo.push(child);
            }
        }
    }
    return nodes;
}

function refenceCenter(url) {
    $("#center").panel({href: basePath + url});
}

function refenceWest(url) {
    console.log("refenceWest,url=" + url);
    $("#west").panel({href: basePath + url});
}

function showDialog(setting, positiveCallback, negativeCallback) {

    setting = setting || {};
    var dlg = $("<div></div>");
    dlg.appendTo("body");
    dlg.dialog($.extend({}, {
        width: 800,
        height: 490,
        closed: false,
        cache: false,
        modal: true,
        buttons: [{
            text: '保存',
            iconCls: 'icon-ok',
            handler: function () {
                if (typeof positiveCallback === "function") {
                    positiveCallback.apply(this, arguments);
                }
            }
        }, {
            text: '关闭',
            iconCls: 'icon-cancel',
            handler: function () {
                if (typeof negativeCallback === "function") {
                    negativeCallback.apply(this, arguments);
                }
                dlg.dialog("destroy");
            }
        }]
    }, setting));

    return dlg;
}