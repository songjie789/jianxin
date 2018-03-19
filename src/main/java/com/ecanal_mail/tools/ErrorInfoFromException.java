package com.ecanal_mail.tools;

import java.io.PrintWriter;
import java.io.StringWriter;



//把异常信息转换成String字符串的类型
public class ErrorInfoFromException {
	public String getErrorInfoFromException(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.close();
            pw.close();	
            return "\r\n" + sw.toString() + "\r\n";
        } catch (Exception e2) {
            return "ErrorInfoFromException";
        }
    }
}
