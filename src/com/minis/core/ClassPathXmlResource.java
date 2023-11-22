package com.minis.core;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import com.minis.beans.BeanDefinition;

public class ClassPathXmlResource implements Resource {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}

	@Override
	public void remove() {
		Resource.super.remove();
	}

	@Override
	public void forEachRemaining(Consumer<? super Object> action) {
		Resource.super.forEachRemaining(action);
	}
}
