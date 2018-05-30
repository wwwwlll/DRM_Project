
<%@page import="com.wj.drm.util.CommonUtil"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false" import="java.io.*"%>
	<%!private final int DEFAULT_BUFFER_SIZE = 4096;
	private final String clientEncoding = "euc-kr";
	private final String jvmEncoding = System.getProperty("file.encoding");
	String fullPath;
	public final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	%>
<%
	String fullPath = request.getParameter("path").replace("encrypt", "decrypt");
	File file = new File(fullPath);
	String fileName = file.getName();
	ServletContext context = getServletContext();
		byte b[] = new byte [4096];
		response.reset();
		response.setContentType("application/octet-stream");
		String Encoding = new String(fileName.getBytes("UTF-8"), "8859_1");
		response.setHeader("Content-Disposition", "attachment; filename = " + Encoding);
		FileInputStream in = new FileInputStream(fullPath);
		ServletOutputStream out2 = response.getOutputStream();
		 try{
		   int numRead;
		   while((numRead = in.read(b, 0, b.length)) != -1){
		    out2.write(b, 0, numRead);
		   }
	LOGGER.info("파일 다운로드 / fullPath = {}",fullPath);
		   LOGGER.info("fileName = "+fileName);
		   new CommonUtil().delDir(fullPath.replace("/"+fileName, ""));
		 }catch(Exception e2){
			//에러 처리
			e2.printStackTrace();

		 }finally{
			   out2.close();
			   in.close();
			   out.clear();
			   out = pageContext.pushBody(); 
		 }

%>
