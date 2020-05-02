package conceptualization;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;

public class HeapSizeCalculator {
	public static void main(String[] args) {
		
		System.out.println("Heap size: " + Runtime.getRuntime().totalMemory());
		System.out.println("Free heap size: "
				+ Runtime.getRuntime().freeMemory());

		for (MemoryPoolMXBean bean : ManagementFactory.getMemoryPoolMXBeans()) {
			if (bean.getType() == MemoryType.HEAP)
				System.out.printf("Name: %s: %s\n", bean.getName(),
						bean.getUsage());
		}
	}
}
