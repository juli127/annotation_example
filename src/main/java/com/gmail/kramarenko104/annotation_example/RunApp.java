package com.gmail.kramarenko104.annotation_example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RunApp {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {

		Object[] motherboards = { new MSI("MSI", "Z370-A PRO"), new Asus("Asus", "Expedition EX-B350-V7") };
		Object[] cpus = { new AMD("AMD B350"), new Intel("Intel B250") };

		String socketM = "";
		String chipsetM = "";
		String cpuSocket = "";
		String cpuChipset = "";
		Class clazzMB = null;
		Class clazzCPU = null;

		for (Object mb : motherboards) {
			clazzMB = mb.getClass();
			System.out.println("---------------------------------------");

			Annotation ann = clazzMB.getAnnotation(Socket.class);
			// check if there is annotation @Socket for motherboard class
			if (ann != null) {
				socketM = ((Socket) ann).name();
			}

			// check if there is annotation @Chipset for field 'mark' in motherboard class
			ann = clazzMB.getDeclaredField("mark").getAnnotation(Chipset.class);
			if (ann != null) {
				chipsetM = ((Chipset) ann).type();
			}

			for (Object cpu : cpus) {
				clazzCPU = cpu.getClass();
				Annotation cpuAnn = clazzCPU.getAnnotation(CPUSocket.class);

				// check if there is annotation @CPUSocket for CPU class
				if (cpuAnn != null) {
					cpuSocket = ((CPUSocket) cpuAnn).name();
				}

				// get 'chipset' field value in CPU class
				Field chipsetField = clazzCPU.getDeclaredField("chipset");
				chipsetField.setAccessible(true);
				if (chipsetField != null) {
					cpuChipset = (String) chipsetField.get(cpu);
				}

				if (!socketM.equals("") && !chipsetM.equals("") && !cpuSocket.equals("") && socketM.equals(cpuSocket)
						&& chipsetM.equals(cpuChipset)) {
					System.out.println("New comp: \nMotherboard: " + mb.toString() + " with socket: '" + socketM
							+ "' and chipset: '" + chipsetM + "'");
					System.out.println("CPU: " + cpu.toString());
				}
			}

		}
	}
}
