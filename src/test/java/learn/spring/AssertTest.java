package learn.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author zt
 * @date 2022/10/26 23:18
 */
@SpringBootTest
public class AssertTest {

	@Test
	void contextLoads() throws ClassNotFoundException {
		String message = "hello";
		Object object = new Object();

		// 要求参数 object 必须为非空（Not Null），否则抛出异常，不予放行
		Assert.notNull(object, message);

		// 要求参数必须空（Null），否则抛出异常，不予『放行』。
		Assert.isNull(object, message);

		// 要求参数必须为真（True），否则抛出异常，不予『放行』。
		Assert.isTrue(true, message);

		// 要求参数（List/Set）必须非空（Not Empty），否则抛出异常，不予放行
		Assert.notEmpty(new ArrayList<>(), message);

		// 要求参数（String）必须有长度（即，Not Empty），否则抛出异常，不予放行
		Assert.hasLength("123", message);

		// 要求参数（String）必须有内容（即，Not Blank），否则抛出异常，不予放行
		Assert.hasText("123", message);

		// 要求参数是指定类型的实例，否则抛出异常，不予放行
		Class testTypeForName = Class.forName("Date");
		Class testTypeClass = Date.class;
		Class testGetClass = new Date().getClass();
		Assert.isInstanceOf(testTypeForName, object, message);
		// 要求参数 `subType` 必须是参数 superType 的子类或实现类，否则抛出异常，不予放行
		Assert.isAssignable(object.getClass(), testTypeForName, message);
	}

}
