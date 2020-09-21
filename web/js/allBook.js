
layui.use(['table',"jquery"], function(){
    var table = layui.table,
        $ = layui.jquery;

    table.render({
        elem:'#bookData',
        height:500,
        url:'book.do?service=allBook',
        page:true,
        toolbar:'default',
        id:"allBook",
        cols:[[
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'bookId', title: '编号', width:80, sort: true, fixed: 'left'}
            ,{field: 'bookName', title: '书名', width:80}
            ,{field: 'price', title: '价格', width:80, sort: true}
            ,{field: 'title', title: '标题', width:80}
            ,{field: 'bookNote', title: '内容', width: 177}
            ,{field: 'bookId', title: '类型编号', width: 177}
            ,{field: 'typeNote', title: '类型', width: 80, sort: true}
            ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}

        ]]

    });
    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            layer.msg('查看操作');
        } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
                //obj.del(); //删除对应行（tr）的DOM结构
                del(data.allBook); // 我删除成功后如何刷新表格
                // 重新加载表格
                table.reload('allBook', {});
                layer.close(index);
                //向服务端发送删除指令
            });
        } else if(layEvent === 'edit'){
            layer.msg('编辑操作');
        }
    });
    function showForm() {
        layer.open({
            type: 1,
            titil:'书籍编辑',
            skin: 'layui-layer-rim', //加上边框
            area: ['420px', '500px'], //宽高
            content:$("#showForm").show(),
            btn: ['保存', '取消'], //可以无限个按钮
            btn1:function () {
                add();
                layer.closeAll();
            },
            btn2:function () {
                layer.closeAll();
            },end:function () {
                $("#showForm").hide();
                //重新加载表格
                table.reload('allBook', {});

                $("#showForm")[0].reset();
            },
        });
        //layer.msg('添加');

    }
    function addBook() {
        //获取保存的数据
        var bookId = $("input[name='bookId']").val();
        var bookName = $("input[name='bookName']").val();
        var price = $("input[name='price']").val();
        var title = $("input[name='title']").val();
        var bookNote = $("input[name='bookNote']").val();
        var typeId = $("input[name='typeId']").val();

        $.ajax({
            type: "POST",
            url: "book.do",
            data: {
                "service": "add",
                "bookId": bookId,
                "bookName": bookName,
                "price": price,
                "title": title,
                "bookNote": bookNote,
                "typeId": typeId


            },
            success: function (msg) {
                layou.msg("保存成功！")


            }

        });

    }

    function del(bookId){
        $.ajax({
            type: "GET", // 请求的类型
            url: "book.do", // 请求的URL
            //data: "com.hd.service=allEmp", // 请求的参数
            data:{
                "service":"del",
                "bookId" : bookId
            },
            // dataType:"json", 后台返回的数据是json ，你就要写类型json
            success: function(msg){

            }
        });
    }
});
