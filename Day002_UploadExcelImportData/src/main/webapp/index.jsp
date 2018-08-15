<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
   <form action="uploadexcel" method="post" enctype="multipart/form-data">
   <input type="file" name="file1">
   
   <input type="submit" value="上传">
   </form>
   <br/>
   
   <a href="downloadexcel">下载excel</a>
  </body>
</html>
