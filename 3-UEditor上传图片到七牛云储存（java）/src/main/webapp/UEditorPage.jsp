<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>UEditor上传图片到七牛（java）</title>
	<script type="text/javascript">
		window.UEDITOR_HOME_URL = '/demo/UEditor/';
	</script>
	<script src="/demo/UEditor/ueditor.config.js" type="text/javascript"></script>
	<script src="/demo/UEditor/ueditor.all.js" type="text/javascript"></script>
</head>
<body>
	<form id="form1" runat="server">
        <script type="text/plain" id="editor" name="editContent" style="width:600px; height:300px;"></script>
        <script type="text/javascript">
            var ue = UE.getEditor('editor');
        </script>
    </form>
</body>
</html>