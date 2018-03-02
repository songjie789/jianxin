package com.ecanal_mail.tools;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
 

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static final String app_id = "2016081900289653";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static final String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC35Xw56tuO6eAMtFw2+x2lqMNSCPTw4HjdXoNDiBe7LtO4sCFLKiX5msRUOX4Hj22SudquRg8WmU7S9O9R+zXKCZS2uGRa3ysAIVybqn1hWkAHgHiQv1tenRTo8lRIXEILlJp6at9Ta9EwrkniIOUU5HjK44HQnF4Vin8Hb/cSLI4qzP7ZVTQ+fE0e+dGdBpzj6z9gW7OYSpnDfsugA1QxGduWQufxNv3bmqxNJRTE7m4kLKDpLFw2B1UYBLLnlPTVVvlEbDsb6K3fNUTnPXBoDk23/beEcqcAV+vst56NFa6zrX/dGxzi7kjN93AWv6JePSMa5wJd2/4lYCHsf7/tAgMBAAECggEAPHxq49Hv7Y3Xd9ZLDnqCQd7Ef9MaXbA3kPhpTGkTBSpd0T19de+jFfpl4R4X6fyvGbevyeqZQ+GhH5oYrWpnQtDr7T2xJIKK7jwK7dih7Md2kAEdpt6J+xDHs+cg+bv+rThvpxxH4HRyFgT9oDcZokmTwYgbRrZn68XmClg1d/BI6b4FxJo2EsUfHrtUBoLqlvq6VRABe1tD8Gy6IYOfVamTiEGTX0GoPV6qDfipFs+h0aHJVqPcK31i4wu++kwt78rCIutRbfcW0YMFOyCRGyLeJHB+RvrQU6yiAs0negLe9V6X5dJucsMMbDbzLKNUIaXTvIdp5/8b/Nwa5KoQsQKBgQDh0ugwc3QJPqVMMTJMIC9KY9USkZb+/L2wQXG2y4jWnwLU24Lp7EF5Kl6H7Dn1PWvHNxJLZTS0lqrnyIX54BgzIjrIHMO8o82wyX82xWwrKthsVG0BYyQ0c+Qgv1nH8WWLQPP3lM4hwytLASYGh5IqBWdU+MpluyYyHTFz9z8hfwKBgQDQeE3kK9RnsrPgJxZ89mq28vvLbTbsPhnRYSuYoKFvEQ7LO4VIEYkSgPvUCp5eGT6eXERvWkrA8y/7fEKbH/ZFAGQjT6/aX99EPSpQFwM9+XhGrRIIdgp6KtHhIYAb+WLKR6ri0gj/0BRUB2Xq6wVeEMurngNDYdrZtqoA1/p8kwKBgQCAWcBwsV41Vu7ahGfDDtPyIxXazPcWjI4/3KKGM97dpVkVpIIe9JIuDN/Xv3MdqUBV5T43rhkrvyr6PGWxpSX8AiuIy5iQ4kUpgw0UE1esnViPEdk23aOZUHlMB5Y+5zxAzrUbde9HD0fPBKMZOPrheVrG1/UppxpJh4AxGkk+fwKBgCGT/xfNZ3z8b7SfFyQxnKazJJNzl/EdX5M2D4uZ8+ar3LIneCRPjsCIPge9XhzR/CANxIgbBwdlJElhjmjmEQi0M2zsnOqTnqajI3ma+060LAdWQR1TxgQ/eWbFupjG5n6mZIP8SK7LmTqfpm7cRBUOp3+RB/2GeXWv0loob5Q5AoGBAMD1XN4PMpAa665554Us+Rbtj0KmrbVeG1c62e1Fh2oEm0dGWrsiMj1kLhjXjpM0eSOI4MZRi4lmjQGK3HxZWo2GWEwWc4D652wSntfckf2s0Xc3ZhM+Z1Rnn2c6gBfAigcfbVNEy+Z5EnQzz1vuZm+BGg7MZzqBgAuyYh4lxUxF";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static final String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtgYYfMJzhAOfEdS7O8XgfG6WUPviEtkmLBKIBY6GP5a4ZbgrB9GV7PokOMtEURE0v/JEakvPYCmIys5ky2VQbqoWytaLporJG/VhfU54GafoDiOFYW39AQ64/eLj6qA7FGp/UZ2AeU90HT5Tt65IeCPW673ZiLU1w7nwEPDLMgH9AE/ftz0PDJdmQkHZdDTvaL8bDkPIyfV9QPqlFq7rkhO5SA0exoCr5jTTRYVmAia6u1e42ucOeSe8q5YYvOWNQnzOXXp/iREiZfzrbgM18IAl96mvHW/l7cUcRPCIVbPJ1wxsIA/oCfJTtmbM92dezcIk6sgzixClfYRCP3/rXQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static final String notify_url = "http://58.56.21.246:9696/e_canal/alipay/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static final String return_url = "http://58.56.21.246:9696/e_canal/alipay/success";

	// 签名方式
	public static final String sign_type = "RSA2";
	
	// 字符编码格式
	public static final String charset = "UTF-8";
	
	// 支付宝网关
	public static final String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


	// 日志路径
	public static final String log_path = "C:\\";


    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
