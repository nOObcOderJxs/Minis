package com.minis.core;

import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ClassPathXmlResource implements Resource{

	Document document;
	Element rootElement;
	Iterator<Element> elementIterator;

	public ClassPathXmlResource(String fileName) {
		SAXReader reader = new SAXReader();
		try {
			URL url = this.getClass().getClassLoader().getResource(fileName);
			this.document = reader.read(url);
			this.rootElement = document.getRootElement();
			this.elementIterator = rootElement.elementIterator();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean hasNext() {
		return this.elementIterator.hasNext();
	}

	@Override
	public Object next() {
		return this.elementIterator.next();
	}
}
