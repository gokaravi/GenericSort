package com.ravi.comparator;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Objects;

public class GenericComparator {
    /**
     * Static method provides the Comparator for the given class and field name
     * Default order is ascending. If it needs to be descending, then the ascending should be false
     * @param clazz
     * @param fieldName
     * @param ascending
     * @param <T>
     * @return Comparator <T>
     */

    public static <T> Comparator<T> getComparator(Class<T> clazz, String fieldName, boolean ascending){

        //Get the field from the class
        final Field field = getField(clazz, fieldName);
        //Make sure the private attributes are accessible
        field.setAccessible(true);

        //Comparator with Lambda
        Comparator<T> comparator = (object1, object2) -> {
            Comparable comparableOne, comparableTwo;
            try {
                comparableOne = (Comparable) field.get(object1);
                comparableTwo = (Comparable) field.get(object2);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
            return Objects.compare(comparableOne, comparableTwo, Comparator.naturalOrder());
        };

        //Reverse the comparator if the order is descending
        if (null != comparator && !ascending)
            comparator = comparator.reversed();

        return comparator;
    }

    /**
     * Method to get the field from the given class and field name
     * @param clazz
     * @param fieldName
     * @param <T>
     * @return Field
     */
    private static <T> Field getField(Class<T> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        }catch(NoSuchFieldException ex){
            throw new RuntimeException(ex);
        }
    }
}
