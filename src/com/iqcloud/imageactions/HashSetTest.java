package com.iqcloud.imageactions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetTest {

	public static void main(String[] args) {
		List<String> orgids = new ArrayList<String>();
		HashSet<String> allUserIds = new HashSet<String>();
		for (int i = 0; i < 10; i++) {
			orgids.add("11111");
			orgids.add("2222");
			allUserIds.addAll(orgids);
		}
		allUserIds.addAll(orgids);
		System.out.println("fffff");
	}

}
