/*
 *  Team: 1540399, ...
 *  Licence: DHBW Stuttgart
 *  Date: Q2
 */

package main;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


/**
 *
 * @param <T> interface that of loaded filter or output aggregate
 */
public class ClassLoader <T> {
    /** This module is used to load different classes.
     *
     * @param path path to jar-file of loaded class
     * @param className name of loaded class
     * @param interfaceClass interface of aggregate
     * @return interface of aggregate
     * @throws MalformedURLException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public T loadClass(String path, String className, Class<T> interfaceClass) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        File file = new File(path);
        URLClassLoader loader = new URLClassLoader(new URL[]{
                file.toURI().toURL()
        });
        Class<?> loadedClass = Class.forName(className, true, loader);
        // concrete class can be output aggregate or filter aggregate
        Class<? extends T> concreteLoadedClass = loadedClass.asSubclass(interfaceClass);
        return concreteLoadedClass.getConstructor().newInstance();
    }
}
