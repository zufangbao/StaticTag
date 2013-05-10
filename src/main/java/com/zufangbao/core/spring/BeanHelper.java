package com.zufangbao.core.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean获取类
 * @author Administrator
 *
 */
public class BeanHelper {
	private static List<String> xmlPathList = new ArrayList<String>();
	static{
		xmlPathList.add("classpath*:/SpringBeans.xml");
	}
	private static ClassPathXmlApplicationContext ctx = null;
	/**
	 * 获取一个Bean工厂
	 * @return
	 */
	private static ClassPathXmlApplicationContext getContext(){
		if (ctx == null){
			syncInitContext();
		}
		return ctx;
	}
	private static synchronized void syncInitContext(){
		if (ctx == null){
			ctx = new ClassPathXmlApplicationContext(xmlPathList.toArray(new String[0]));
		}
	}
	/**
	 * 添加一个bean配置xml文件
	 * 注意：添加请写在main入口处，防止添加过程中有引用getInstance的情况，否则可能发生异常
	 * @param xmlClassPath 示例:classpath*:/applicationContext.xml
	 */
	public static synchronized void addXmlClassPath(String xmlClassPath){
		if (xmlPathList.contains(xmlClassPath)) return;
		xmlPathList.add(xmlClassPath);
		ctx = null;
	}
	/**
	 * 获取一个Bean实例
	 * @param clazz
	 * @return
	 */
	public static <T> T getInstance(Class<T> clazz) {
		ClassPathXmlApplicationContext cpxac = getContext();
		return cpxac.getBean(clazz);
	}
}
