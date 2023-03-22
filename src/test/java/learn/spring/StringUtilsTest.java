package learn.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zt
 * @date 2022/10/26 23:47
 */
@SpringBootTest
public class StringUtilsTest {

	public static void main(String[] args) {
//		String a = "abcd_efgh_ijklmn_";
//		String before2 = a.substring(0,a.indexOf("_",a.indexOf("_") + 1));
//		System.out.println("第二个_前面字符串为：" + before2);

		String a = "abcd_efgh_ijklmn_";
		String after2 = a.substring(a.indexOf("_",a.indexOf("_") + 1) + 1);
		System.out.println("第二个_后面字符串为：" + after2);
	}
	@Test
	void file(){
		String file = "./../.sou/ima.qq.png";
		String file2 = "./../.sou/ima123123.png";
		// 解析路径字符串，优化其中的 “..”
		System.out.println(StringUtils.cleanPath("./../.sou/ima.png"));
		// 解析路径字符串，解析出文件名部分
		System.out.println(StringUtils.getFilename(file));
		// 解析路径字符串，解析出文件后缀名
		System.out.println(StringUtils.getFilenameExtension(file));
		// 比较两个两个字符串，判断是否是同一个路径。会自动处理路径中的 “..”
		System.out.println(StringUtils.pathEquals(file, file2));

		// 删除文件路径名中的后缀部分
		System.out.println(StringUtils.stripFilenameExtension(file));
		// 以 “. 作为分隔符，获取其最后一部分
		System.out.println(StringUtils.unqualify(file));
		// 以指定字符作为分隔符，获取其最后一部分
		System.out.println(StringUtils.unqualify(file, 'q'));
	}
	@Test
	void use(){
		String aaa = "aaa";
		String bbb = "bbb";
		String bbbaaa = "bbbaaababaa";
		String ccc = " c c c ";

		// 查找并替换指定子串
		String newPattern = "aaa";
		String oldPattern = "bbb";
		String inString = "bbbaaababa";
		System.out.println(StringUtils.replace(inString, oldPattern, newPattern));

		// 去除尾部的特定字符
		System.out.println(StringUtils.trimTrailingCharacter(bbbaaa, 'a'));
		// 去除头部的特定字符
		System.out.println(StringUtils.trimLeadingCharacter(bbbaaa, 'b'));
		// 去除头部的空白符
		System.out.println(StringUtils.trimLeadingWhitespace(ccc));
		// 去除尾部的空白符
		System.out.println(StringUtils.trimTrailingWhitespace(ccc));
		// 去除头部和尾部的空白符
		System.out.println(StringUtils.trimWhitespace(ccc));
		// 删除开头、结尾和中间的空白符
		System.out.println(StringUtils.trimAllWhitespace(ccc));

		// 删除指定子串
		System.out.println(StringUtils.delete(inString, oldPattern));
		// 删除指定字符（可以是多个）
		System.out.println(StringUtils.deleteAny(inString, "ba"));
		// 对数组的每一项执行 trim() 方法
		List<String> objects = new ArrayList<>();
		String[] strings = {ccc,ccc};
		objects.add(ccc);
		objects.add(ccc);
		StringUtils.trimArrayElements(strings);

		// 将 URL 字符串进行解码
//		System.out.println(StringUtils.uriDecode("%5", Charset.defaultCharset()));

	}

	@Test
	void base(){
		String s = "";
		// 判断字符串是否为 null，或 ""。注意，包含空白符的字符串为非空
		System.out.println(StringUtils.isEmpty(s));

		// 判断字符串是否是以指定内容结束。忽略大小写
		System.out.println(StringUtils.endsWithIgnoreCase("abc_fix", "suffix"));

		// 判断字符串是否已指定内容开头。忽略大小写
		System.out.println(StringUtils.startsWithIgnoreCase("prefix_fix", "prefix"));

		// 是否包含空白符
		System.out.println(StringUtils.containsWhitespace(s));

		// 判断字符串非空且长度不为 0，即，Not Empty
		System.out.println(StringUtils.hasLength(null));

		// 判断字符串是否包含实际内容，即非仅包含空白符，也就是 Not Blank
		System.out.println(StringUtils.hasText(null));

		// 判断字符串指定索引处是否包含一个子串。
		System.out.println(StringUtils.substringMatch("abc_qwe_rty", 3, "_qwe"));
		System.out.println(StringUtils.substringMatch("012_qwe_rty", 3, "qwe"));
		// 计算一个字符串中指定子串的出现次数
		System.out.println(StringUtils.countOccurrencesOf("abcababbbaabab", "ab"));
	}
}
