package org.ash.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.ash.utils.DataProviderUtility;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtility.class);
		annotation.setRetryAnalyzer(RetryListner.class);
	}
}
