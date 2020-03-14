package utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * {@code BeanTester} is a helper for Java Bean using Mockito and Whitebox(in PowerMock). <br/>
 * It can randomly simulate the parameter value of getter and the property value of setter.
 *
 * @param <T>
 */
public class BeanTester<T> {

    private static Random random = new Random();
    private static int RANDOM_FEED = 1000000;

    private T targetObj;
    private List<PropertyDescriptor> descriptors;

    /**
     * using this constructor to test all of the getters and setters declared in this class
     *
     * @param targetObj test class instance
     */
    public BeanTester(T targetObj) {
        this(targetObj, null);
    }

    /**
     * using this constructor to test getters and setters of specified properties
     *
     * @param targetObj   test class instance
     * @param propsFilter specified properties
     */
    public BeanTester(T targetObj, List<String> propsFilter) {
        Class<T> targetClz = (Class<T>) targetObj.getClass();
        this.descriptors = getPropertyDescriptors(targetClz, propsFilter);
        this.targetObj = targetObj;
    }

    /**
     * Test getters
     */
    public void testGetters() {
        for (PropertyDescriptor propDesc : descriptors) {
            this.testGetter(propDesc);
        }
    }

    /**
     * Test setters
     */
    public void testSetters() {
        for (PropertyDescriptor propDesc : descriptors) {
            this.testSetter(propDesc);
        }
    }

    private void testGetter(PropertyDescriptor descriptor) {
        Method getter = descriptor.getReadMethod();
        String propName = descriptor.getName();
        if (getter == null || propName == null) {
            return;
        }
        Class<?> propType = descriptor.getPropertyType();
        Object propMockValue = getMockValue(propType);
        Whitebox.setInternalState(this.targetObj, propName, propMockValue);
        try {
            Object propRealValue = getter.invoke(this.targetObj);
            Assert.assertEquals(propMockValue, propRealValue);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.printf(">> error occurred when testing property [%s] getter.%n", propName);
        }
    }

    private void testSetter(PropertyDescriptor descriptor) {
        Method setter = descriptor.getWriteMethod();
        String propName = descriptor.getName();
        if (setter == null || propName == null) {
            return;
        }

        Class<?> propType = descriptor.getPropertyType();
        Object propMockValue = getMockValue(propType);
        Parameter[] params = setter.getParameters();
        if (params.length != 1) {
            return;
        }

        try {
            setter.invoke(this.targetObj, propMockValue);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.printf(">> error occurred when testing property [%s] getter.%n", propName);
        }
        Object propRealValue = Whitebox.getInternalState(this.targetObj, propName);
        Assert.assertEquals(propMockValue, propRealValue);
    }

    private <T> List<PropertyDescriptor> getPropertyDescriptors(Class<? extends T> beanClass, List<String> propsFilter) {
        Preconditions.checkNotNull(beanClass, "base class should be not null.");
        List<PropertyDescriptor> descriptors = null;
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
            descriptors = Lists.newArrayList(beanInfo.getPropertyDescriptors()).stream()
                    .filter(descriptor -> {
                        if (Objects.isNull(descriptor)) {
                            return false;
                        }
                        try {
                            return Objects.nonNull(beanClass.getDeclaredField(descriptor.getName()));
                        } catch (NoSuchFieldException e) {
                            return false;
                        }
                    })
                    .filter(descriptor -> {
                        if (propsFilter == null || propsFilter.contains(descriptor.getName())) {
                            return true;
                        } else {
                            return false;
                        }
                    })
                    .collect(Collectors.toList());
        } catch (IntrospectionException e) {
            // nothing to do
        }
        return descriptors;
    }

    private Object getMockValue(Class<?> propType) {
        Object mockValue = null;
        if (propType.isAssignableFrom(long.class) || propType.isAssignableFrom(Long.class)) {
            long randomLong = random.nextLong();
            mockValue = randomLong < 0 ? -randomLong : randomLong;
        } else if (propType.isAssignableFrom(int.class) || propType.isAssignableFrom(Integer.class)) {
            mockValue = random.nextInt(RANDOM_FEED);
        } else if (propType.isAssignableFrom(short.class) || propType.isAssignableFrom(Short.class)) {
            mockValue = (short) (random.nextFloat() * 10000 % Short.MAX_VALUE);
        } else if (propType.isAssignableFrom(byte.class) || propType.isAssignableFrom(Byte.class)) {
            mockValue = (byte) (random.nextFloat() * 10 % Byte.MAX_VALUE);
        } else if (propType.isAssignableFrom(double.class) || propType.isAssignableFrom(Double.class)) {
            mockValue = random.nextDouble();
        } else if (propType.isAssignableFrom(float.class) || propType.isAssignableFrom(Float.class)) {
            mockValue = random.nextFloat();
        } else if (propType.isAssignableFrom(char.class) || propType.isAssignableFrom(Character.class)) {
            mockValue = (char) (random.nextInt(26) + (random.nextBoolean() ? 'A' : 'a'));
        } else if (propType.isAssignableFrom(Boolean.class) || propType.isAssignableFrom(boolean.class)) {
            mockValue = Boolean.TRUE;
        } else if (propType.isAssignableFrom(String.class)) {
            mockValue = "random-string-" + random.nextInt(RANDOM_FEED);
        } else if (propType.isAssignableFrom(UUID.class)) {
            mockValue = UUID.randomUUID();
        } else if (propType.isAssignableFrom(BigDecimal.class)) {
            mockValue = BigDecimal.valueOf(random.nextInt(RANDOM_FEED));
        } else if (propType.isAssignableFrom(Date.class)) {
            mockValue = Mockito.mock(Date.class);
        } else if (!propType.isPrimitive() || !propType.isAnonymousClass() || !Modifier.isFinal(propType.getModifiers())) {
            mockValue = Mockito.mock(propType);
        } else {
            throw new IllegalArgumentException("Mock value filed for class: " + propType.getName());
        }
        return mockValue;
    }

}
