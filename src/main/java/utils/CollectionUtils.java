package utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Some simple utils for common usage <p>
 */
public class CollectionUtils {


    /**
     * Simply returns an empty set if the parssed-in set is null.
     */
    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set != null ? set : Collections.<T>emptySet();
    }


    /**
     * Simply returns an empty list if the passed-in list is null.
     */
    public static <T> List<T> emptyIfNull(List<T> list) {
        return list != null ? list : Collections.<T>emptyList();
    }

    /**
     * If map is non-null, returns map; else returns empty map.
     */
    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> map) {
        return map != null ? map : Collections.<K, V>emptyMap();
    }

    /**
     * Simply returns an empty collection if the passed-in collection is null.
     */
    public static <T> Collection<T> emptyIfNull(Collection<T> collection) {
        return collection != null ? collection : Collections.<T>emptyList();
    }

}
