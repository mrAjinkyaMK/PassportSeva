package com.UtilsLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.BaseLaye.BaseClass;

public class HandleWindows extends BaseClass {

	public static ArrayList<String> handleWindow(Set<String> allWindow) {
		ArrayList<String> arr = new ArrayList<String>();
		Iterator<String> itr = allWindow.iterator();

		while (itr.hasNext()) {
			arr.add(itr.next());
		}

		return arr;
	}

	public static String handleWindow(Set<String> allWindow, String parentId) {
		for (String abc : allWindow) {
			if (parentId != abc) {
				return abc;
			}
		}
		return null;
	}

	public static String handleThreeWindow(Set<String> allWindow, String parentId, String otherWinId) {
		for (String abc : allWindow) {
			if ((parentId != abc) && (otherWinId != abc)) {
				return abc;
			}

		}
		return null;
	}

	public static ArrayList<String> handleWindowUsingArray(Set<String> allWindow) {
		ArrayList<String> arr = new ArrayList<String>(allWindow);
		return arr;
	}
}
