 var testEditor;
 
$(function() {
    testEditor = editormd("test-editormd", {
        placeholder : '本编辑器支持Markdown编辑，左边编写，右边预览',//这里不设置则为默认的
        width   : "90%",
        height  : 640,
        syncScrolling : "single",
        path    : "../editormd/lib/",//lib路径
        imageUpload : true,
        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL : "/fileUpload",//图片上传请求Url
        saveHTMLToTextarea : true,//保存html到textarea
        emoji: true,
        taskList: true,
        tocm: true,         // Using [TOCM]
        tex: true,                   // 开启科学公式TeX语言支持，默认关闭
        flowChart: true,             // 开启流程图支持，默认关闭
        sequenceDiagram: true// 开启时序/序列图支持，默认关闭
 
        //editor.md期望得到一个json格式的上传后的返回值，格式是这样的：
        /*
         {
         success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
         message : "提示的信息，上传成功或上传失败及错误信息等。",
         url     : "图片地址"        // 上传成功时才返回
         }
         */
    });
});
