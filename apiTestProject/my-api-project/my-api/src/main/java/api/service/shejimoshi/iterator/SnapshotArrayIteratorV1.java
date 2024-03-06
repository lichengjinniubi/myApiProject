package api.service.shejimoshi.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 迭代的时候拷贝一份
 * @param <E>
 */
public class SnapshotArrayIteratorV1<E> implements Iterator<E> {

    private int coursor;
    private ArrayList<E> list;
    public SnapshotArrayIteratorV1(ArrayList<E> arrayList){
        this.coursor = 0;
        this.list.addAll(arrayList);
    }
    @Override
    public boolean hasNext() {
        return this.coursor < list.size();
    }

    @Override
    public E next() {
        E e = list.get(coursor);
        coursor++;
        return e;
    }
}
