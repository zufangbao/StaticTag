package com.zufangbao.web.tag;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.NamedThreadLocal;

public class StaticTagHolder {
	private static final ThreadLocal<List<StaticItem>> staticItemsHolder = new NamedThreadLocal<List<StaticItem>>("StaticItems");

	public static void reset() {
		staticItemsHolder.set(null);
	}

	public static void set(List<StaticItem> obj) {
		staticItemsHolder.set(obj);
	}

	public static List<StaticItem> get() {
		List<StaticItem> list = staticItemsHolder.get();
		if (list == null) list = new ArrayList<StaticItem>();
		return list;
	}
}
