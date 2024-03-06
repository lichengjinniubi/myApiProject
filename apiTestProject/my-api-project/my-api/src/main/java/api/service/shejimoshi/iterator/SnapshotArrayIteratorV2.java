package api.service.shejimoshi.iterator;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class SnapshotArrayIteratorV2 implements Iterator {
    @Autowired
    private ArrayList arrayList;


    @Override
    public boolean hasNext() {
        return arrayList.size() > 0;
    }

    @Override
    public Object next() {
        return null;
    }
}
