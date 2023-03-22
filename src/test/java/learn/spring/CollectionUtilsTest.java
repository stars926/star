package learn.spring;

import com.star.web.admin.pojo.po.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author zt
 * @date 2022/10/27 0:20
 */
@SpringBootTest
public class CollectionUtilsTest {
	@Test
	void use() {
		ArrayList<Object> objects = new ArrayList<>();
		HashSet<Object> objects1 = new HashSet<>();
		Object array = new Object();
		// 将 Array 中的元素都添加到 List/Set 中
		CollectionUtils.mergeArrayIntoCollection(array, objects);
		// 将 Properties 中的键值对都添加到 Map 中
		Properties properties = new Properties();
		properties.put("key", "value");
		HashMap<Object, Object> map = new HashMap<>();
		CollectionUtils.mergePropertiesIntoMap(properties, map);
		// 返回 List 中最后一个元素
		System.out.println(CollectionUtils.lastElement(objects));
		// 返回 Set 中最后一个元素
		System.out.println(CollectionUtils.lastElement(objects1));
		// 返回参数 candidates 中第一个存在于参数 source 中的元素
		ArrayList<Object> candidates = new ArrayList<>();
		ArrayList<Object> source = new ArrayList<>();
		CollectionUtils.findFirstMatch(source, candidates);
		// 返回 List/Set 中指定类型的元素。
		CollectionUtils.findValueOfType(source, Object.class);
		// 返回 List/Set 中指定类型的元素。如果第一种类型未找到，则查找第二种类型，以此类推
		CollectionUtils.findValueOfType(source, new Class[]{Object.class, Date.class});
		// 返回 List/Set 中元素的类型
		CollectionUtils.findCommonElementType(source);
	}

	@Test
	void base() {
		ArrayList<Object> objects = new ArrayList<>();
		HashMap<Object, Object> map = new HashMap<>();
		// 判断 List/Set 是否为空
//		System.out.println(CollectionUtils.isEmpty(null));
		System.out.println(CollectionUtils.isEmpty(objects));
		// 判断 Map 是否为空
		System.out.println(CollectionUtils.isEmpty(map));
		// 判断 List/Set 中是否包含某个对象
		List<SysUser> sysUsers = new ArrayList<>();
		sysUsers.add(User.getUserOne());
		sysUsers.add(User.getUserTwo());
		System.out.println(CollectionUtils.containsInstance(sysUsers, User.getUserTwoEq()));
		// 以迭代器的方式，判断 List/Set 中是否包含某个对象
		System.out.println(CollectionUtils.contains(sysUsers.listIterator(), User.getUserTwoEq()));
		// 判断 List/Set 是否包含某些对象中的任意一个
		List<SysUser> source = new ArrayList<>();
		sysUsers.add(User.getUserOne());
		sysUsers.add(User.getUserTwo());
		List<SysUser> candidates = new ArrayList<>();
		sysUsers.add(User.getUserOne());
		List<SysUser> candidates2 = new ArrayList<>();
		sysUsers.add(new SysUser());
		System.out.println(CollectionUtils.containsAny(source, candidates));
		System.out.println(CollectionUtils.containsAny(source, candidates2));
		// 判断 List/Set 中的每个元素是否唯一。即 List/Set 中不存在重复元素
		System.out.println(CollectionUtils.hasUniqueObject(sysUsers));
		sysUsers.add(User.getUserTwoEq());
		System.out.println(CollectionUtils.hasUniqueObject(sysUsers));
	}
}
