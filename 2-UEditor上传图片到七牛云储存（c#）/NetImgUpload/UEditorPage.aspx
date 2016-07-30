<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="UEditorPage.aspx.cs" Inherits="NetImgUpload.UEditorPage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>UEditor上传图片到七牛（.net）</title>
    <script src="/UEditor/ueditor.config.js" type="text/javascript"></script>
    <script src="/UEditor/ueditor.all.js" type="text/javascript"></script>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <script type="text/plain" id="editor" name="editContent" style="width:600px; height:300px;"></script>
        <script type="text/javascript">
            var ue = UE.getEditor('editor');
        </script>
    </div>
    </form>
</body>
</html>
