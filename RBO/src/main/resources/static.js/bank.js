var url;

// 页面加载
$(function () {
    $("#dg").datagrid({
        url: 'list',
        queryParams: {},
        title: "list",
        rownumbers: true,
        fit: true,
        toolbar: "#tb",
        collapsible: true,
        pagination: true,
        pageSize: 5,
        pageList: [5, 10],
        columns: [[
            {field: 'id', title: 'ID', width: 50, align: 'center', halign: 'center', hidden: 'true'},
            {field: 'bank_code', title: 'BANK_CODE', width: 200, align: 'center', halign: 'center'},
            {field: 'headquarters_code', title: 'HEADQUARTERS_CODE', width: 200, align: 'right', halign: 'center'},
            {field: 'branch_bank_code', title: 'BRANCH_BANK_CODE', width: 200, align: 'center', halign: 'center'},
            {field: 'bank_name', title: 'BANK_NAME', width: 200, align: 'center', halign: 'center'},
            {field: 'status', title: 'STATUS', width: 200, align: 'center', halign: 'center'},
            {field: 'creator', title: 'CREATOR', width: 200, align: 'center', halign: 'center'},
            {field: 'cdate', title: 'CDATE', width: 200, align: 'center', halign: 'center'},
            {field: 'editor', title: 'EDITOR', width: 200, align: 'center', halign: 'center'},
            {field: 'edate', title: 'EDATE', width: 200, align: 'center', halign: 'center'}
        ]]
    });
});

// 【加载全部】按钮押下处理
var loadAll = function () {
    // 查询条件还原为默认状态
    $('#searchcondition').combobox('setValue', 'bank_code');
    $('#searchcontent').val("");

    // 表格重新加载
    var param = {};
    $("#dg").datagrid('load', param);
};

// 【搜索】按钮押下处理
var queryAction = function () {
    var param = {
        searchcondition: $('#searchcondition').combobox('getValue'),
        searchcontent: $('#searchcontent').val()
    };

    $("#dg").datagrid('load', param);
};

// 重置表单内容
var resetValue = function () {
    $('#fm')[0].reset();
};

// 打开添加对话框
var openAddDialog = function () {
    resetValue();
    $('#dlg').dialog({
        modal: true,
        title: '添加人员信息'
    });
    $('#dlg').dialog("open");
    url = "save";
};

// 新增处理
var saveAction = function () {
    $("#fm").form("submit", {
        url: url,
        onSubmit: function () {
            return $(this).form("validate");
        },
        success: function (result) {
            var result = eval('(' + result + ')');
            if (result.success) {
                $.messager.alert("系统提示", "保存成功！");
                resetValue();
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
            } else {
                $.messager.alert("系统提示", "保存失败！");
                return;
            }
        }
    });
};

// 关闭对话框
var closeDialog = function () {
    $("#dlg").dialog("close");
    resetValue();
};

// 打开编辑对话框
var openModifyDialog = function () {
    var selectedRows = $("#dg").datagrid("getSelections");

    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }

    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑人员信息");
    $("#fm").form("load", row);
    url = "save?personid=" + row.personid;
};

// 删除处理
var deleteAction = function () {
    var selectedRows = $("#dg").datagrid("getSelections");

    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据");
        return;
    }

    $.messager.confirm("系统提示", "您确定要删除这<font color=red>" + selectedRows.length + "</font>条数据吗？", function (r) {
        if (r) {
            $.post("delete", {
                id: selectedRows[0].personid
            }, function (result) {
                if (result.success) {
                    $.messager.alert("系统提示", "数据已成功删除！");
                    $("#dg").datagrid("reload");
                } else {
                    $.messager.alert("系统提示", "数据删除失败，请联系工作人员！");
                }
            }, "json");
        }
    });
};