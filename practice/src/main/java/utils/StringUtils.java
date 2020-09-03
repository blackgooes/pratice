package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static String numRegex = "[^0-9.]";

	public static String getLongNumber(String oriNum) {
		if (isBlank(oriNum)) {
			return "0";
		}
		Pattern p = Pattern.compile(numRegex);
		Matcher matcher = p.matcher(oriNum);
		return matcher.replaceAll("").trim();
	}

	public static boolean isNumeric(String str){
		if (StringUtils.isBlank(str)) {
			return false;
		}
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();
	}

	/**
	 * 存在大写转下划线加小写 bA -> b_a
	 * @param param
	 * @return
	 */
	public static String camel4underline(String param){
		Pattern p=Pattern.compile("[A-Z]");
		if(param==null ||param.equals("")){
			return "";
		}
		StringBuilder builder=new StringBuilder(param);
		Matcher mc=p.matcher(param);
		int i=0;
		while(mc.find()){
			builder.replace(mc.start()+i, mc.end()+i, "_"+mc.group().toLowerCase());
			i++;
		}

		if('_' == builder.charAt(0)){
			builder.deleteCharAt(0);
		}
		return builder.toString();
	}

}
