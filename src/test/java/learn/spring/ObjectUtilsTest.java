package learn.spring;

import com.star.web.admin.pojo.po.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zt
 * @date 2022/10/26 23:29
 */
@SpringBootTest
public class ObjectUtilsTest {
	@Test
	void use(){
		List<Object> objects = new ArrayList<>();

		// 判断数组是否为空
		System.out.println(ObjectUtils.isEmpty(null));
		System.out.println(ObjectUtils.isEmpty(objects));

		// 判断参数对象是否是数组
		System.out.println(ObjectUtils.isArray(objects));

		// 判断数组中是否包含指定元素
		List<SysUser> sysUsers = new ArrayList<>();
		sysUsers.add(User.getUserOne());
		sysUsers.add(User.getUserTwo());
		System.out.println(ObjectUtils.containsElement(sysUsers.toArray(), User.getUserTwoEq()));

		// 相等，或同为 null时，返回 true
		System.out.println(ObjectUtils.nullSafeEquals(User.getUserOne(), User.getUserTwo()));
		/*
			判断参数对象是否为空，判断标准为：
    		Optional: Optional.empty()
       		Array: length == 0
			CharSequence: length == 0
  			Collection: Collection.isEmpty()
         	Map: Map.isEmpty()
 		*/
		System.out.println(ObjectUtils.isEmpty(null));

		// 向参数数组的末尾追加新元素，并返回一个新数组
		Object[] objects1 = ObjectUtils.addObjectToArray(sysUsers.toArray(), User.getUserTwoEq());
		System.out.println(objects1);
		// 原生基础类型数组 --> 包装类数组
		Object[] objects2 = ObjectUtils.toObjectArray(User.getUserTwo());
	}

	@Test
	void contextLoads(){
		// 获取对象的类名。参数为 null 时，返回字符串："null"
		ObjectUtils.nullSafeClassName(null);

		// 参数为 null 时，返回 0
		ObjectUtils.nullSafeHashCode(new Object());

		// 参数为 null 时，返回字符串："null"
		ObjectUtils.nullSafeToString(new boolean[0]);

		// 获取对象 HashCode（十六进制形式字符串）。参数为 null 时，返回 0
		ObjectUtils.getIdentityHexString(null);

		// 获取对象的类名和 HashCode。 参数为 null 时，返回字符串：""
		ObjectUtils.identityToString(new Object());

		// 相当于 toString()方法，但参数为 null 时，返回字符串：""
		ObjectUtils.getDisplayString(null);
	}
}
