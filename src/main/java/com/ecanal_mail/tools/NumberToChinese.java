package com.ecanal_mail.tools;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 阿拉伯数字转中文 ,中文转数字
 * @author lyb
 *
 */
public class NumberToChinese {

	private static Map<Character,Character> chineseMap;//数字
	private static Map<Integer,String> danMap;//单位
	private static char zdan[]={'圆','拾','佰','仟','万','拾','佰','仟','亿',
									 '拾','佰','仟','万','拾','佰','仟','亿',
									 '拾','佰','仟','万','拾','佰','仟','亿',
									 '拾','佰','仟','万','拾','佰','仟','亿'};
	private static char xdan[]={'角','分','厘','毫','丝','忽'};
	static {
		chineseMap=new HashMap<Character,Character>();
		chineseMap.put('0','零');
		chineseMap.put('1','壹');
		chineseMap.put('2','贰');
		chineseMap.put('3','叁');
		chineseMap.put('4','肆');
		chineseMap.put('5','伍');
		chineseMap.put('6','陆');
		chineseMap.put('7','柒');
		chineseMap.put('8','捌');
		chineseMap.put('9','玖');
		danMap=new HashMap<Integer, String>();
		danMap.put(0,"圆");
		danMap.put(1,"拾");
		danMap.put(2,"佰");
		danMap.put(3,"仟");
		danMap.put(4,"万");
		danMap.put(5,"拾");
		danMap.put(6,"佰");
		danMap.put(7,"仟");
		danMap.put(8, "亿");
		danMap.put(9,"拾");
		danMap.put(10,"佰");
	} 
	
	/**
	 * 将一个字符串类型的数字转化为大写<br>
	 * 传入参数为null时，返回null<br.
	 * 传入参数为空，返回空<br>
	 * 传入参数不是一个数字，返回该参数<br>
	 * 
	 * @param number String
	 * @return String
	 */
	private static String  formatToChinese(String number)throws Exception{
		
		if(number==null){
			return null;
		}
		if(number.equals("")){
			return "";
		}
		 try {
			 new BigDecimal(number);
		} catch (Exception e) {
			 throw e;
		}
		
		
		
		//若没有"."，就加一个
		if(!number.contains(".")){
			//System.out.println("没有点");
			number+=".0";
		}
		//以“.”分隔开，没有“.” 以“整”结尾
		String strnumber=number;
		String a=strnumber.substring(0, strnumber.indexOf("."));
		String b=strnumber.substring(strnumber.indexOf(".")+1);
		while(b.endsWith("0")){
			b=b.substring(0,b.length()-1);
		}
		
		//转为汉字
		char arr[]=a.toCharArray();
		char brr[]=b.toCharArray();
		char chineseArr[]=new char[arr.length];
		char chineseBrr[]=new char[brr.length];
		for (int i = 0; i < arr.length; i++) {
			chineseArr[i]=chineseMap.get(arr[i]);
		}
		for (int i = 0; i < brr.length; i++) {
			chineseBrr[i]=chineseMap.get(brr[i]); 
		}
		
		
		//加单位
		//小数部分
		String bs="";
		for (int i = 0; i < brr.length; i++) {
			if((brr.length==1)&&(brr[i]=='0')){//没有小数
				bs="整";
				break;
			}else{
				bs+=new String(new char[]{chineseBrr[i],xdan[i]});
			}
			bs=bs.replace("零角", "零");
			bs=bs.replace("零分", "零");
			bs=bs.replace("零厘", "零");
			bs=bs.replace("零毫", "零");
			bs=bs.replace("零丝", "零");
			bs=bs.replace("零忽", "");
			while(bs.contains("零零")){
				bs=bs.replace("零零","零");
			}
		}

		bs=bs.replace("零角", "零");
		bs=bs.replace("零分", "");

		//整数部分
		String as="";
		for (int i = arr.length-1; i >=0; i--) {
			as=new String(new char[]{chineseArr[i],zdan[arr.length-1-i]})+as;
		}

		as=as.replace("零拾","零");
		as=as.replace("零佰","零");
		as=as.replace("零仟","零");
		while(as.contains("零零")){
			as=as.replace("零零","零");
		}
		as=as.replace("零亿","亿");
		as=as.replace("零万","万");
		as=as.replace("亿万", "亿");
		as=as.replace("零圆","圆");
		
		String result =as+bs;
		
		if(result.startsWith("圆")){//以“圆”开头
			result = result .replace("圆","");
		}
		if(result.startsWith("零")){
			result = result .replace("零","");
		}
		if(result.length()==0){
			result="零圆";
		}
		if(result.endsWith("圆")){
			result=result.concat("整");
		}
		return result;
	 
	}
	 

	/**
	 * 将小写金额转为汉字大写
	 * @param number long
	 * @return String
	 * @throws Exception
	 */
	public static String formatToChinese(long number) throws Exception{

		String str=String.valueOf(number);
		return formatToChinese(str);
	}

	/**
	 *  将小写金额转为汉字大写
	 * @param number float
	 * @return String
	 * @throws Exception
	 */
	public static String formatToChinese(float number) throws Exception{
	
		String str=String.valueOf(number);
		BigDecimal b=new BigDecimal(str);
		double d=Double.valueOf(b.toString());
		return formatToChinese(d);
	}
	/**
	 *  将小写金额转为汉字大写
	 * @param number double
	 * @return String
	 * @throws Exception
	 */
	public static String formatToChinese(double number) throws Exception{

		String str = String.valueOf(number);
		BigDecimal b = new BigDecimal(str);
		String s = b.toString();
		
		return formatToChinese(s); 
	}
 
 
}
