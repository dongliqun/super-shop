package com.fengze.shop.utils;

@SuppressWarnings("unchecked")
public class DaoFactory {

	private static final DaoFactory daoFactory = new DaoFactory();
	
	private DaoFactory() {}
	
	public static DaoFactory getInstance() {
		return daoFactory;
	}
	
	public <T> T createDao (String className, Class<T> clazz) {
		try {
			T t = (T) Class.forName(className).newInstance();
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
