package generic;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/7/5 19:35
 * @desc:
 */

public interface Box<T> {

    T get();
    public void put(T element);
}
