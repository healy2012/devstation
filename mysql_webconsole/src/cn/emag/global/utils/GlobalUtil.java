package cn.emag.global.utils;

import java.util.Random;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 工具类
 * 
 * @author pc
 * @version [1.0, Jul 8, 2011]
 * @since 统一平台开发1.0
 */
public class GlobalUtil {
	/**
	 * 生成随机验证码
	 * 
	 * @param validateChars
	 *            验证码中可能用到的字符
	 * @param length
	 *            生成验证码的长度
	 * @return String 随机验证码
	 */
	public static String generateValiCode(char[] validateChars, int length) {
		// 用于将字符组装成字符串最后输出
		StringBuffer valiCode = new StringBuffer();

		Random random = new Random();

		// 随机索引
		int randomIndex;

		for (int i = 0; i < length; i++) {
			// 在给定的字符数组长度中获得随机索引
			randomIndex = random.nextInt(validateChars.length);

			// 根据随机索引获得该索引对应的字符
			valiCode.append(validateChars[randomIndex]);

		}

		return valiCode.toString();
	}

	/*
	 * public static void main(String[] args) { char[] validateChars = { 'A',
	 * 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
	 * 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
	 * '3', '4', '5', '6', '7', '8', '9' };
	 * 
	 * String validateCode = generateValiCode(validateChars,6);
	 * 
	 * System.out.println(validateCode); }
	 */

	/**
	 * 根据父节点code和子节点最大code生成新的code
	 */
	public static String generatorTreeCode(String parentCode,
			String childrenMaxCode) {
		if (StringUtils.isBlank(childrenMaxCode)) {
			return parentCode + "01";
		}
		String maxCode = StringUtils.remove(childrenMaxCode, parentCode);
		String newCode = String.valueOf(Integer.parseInt(maxCode) + 1);
		if (newCode.length() == 1) {
			newCode = "0" + newCode;
		}
		return parentCode + newCode;
	}
	
	/**
     * 条件查询时，排除页面输入值为%、_特殊符号时得到的查询结果不正确
     * @param original 页面代入的初始值
     * @return String 转换后的字符串
     */
    public static String likeEscape(String original) {
        if (StringUtils.isEmpty(original))
            return original;
        int length = original.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = original.charAt(i);
            if (c == '\\')
                sb.append("\\\\");
            else if (c == '_')
                sb.append("\\_");
            else if (c == '%')
                sb.append("\\%");
            else if (c == '\'')
                sb.append("\'\'");
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
