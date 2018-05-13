package tester;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 1, 4, 2, 3, 4, 77, 88, 777, 88 };
		Set<Integer> arrs = new HashSet<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (!arrs.contains(i)) {
				map.put(i, 0);
			}
			arrs.add(i);
			if (arrs.contains(i)) {
				Integer num = map.get(i);
				map.put(i, ++num);
			}
		}
		for (Integer key : map.keySet()) {
			System.out.println(key+"出现:"+map.get(key)+"次");
		}
		System.out.println(map.toString());
	}
}
