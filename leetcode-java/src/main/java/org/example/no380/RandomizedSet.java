package org.example.no380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

    private final Map<Integer, Integer> map;
    private final List<Integer> list;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            map.remove(val);
            int listSize = list.size();
            if (index == listSize - 1) {
                list.remove(index);
            } else {
                int lastValue = this.list.get(listSize - 1);
                this.list.set(index, lastValue);
                this.map.put(lastValue, index);
                this.list.remove(listSize - 1);
            }
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));


    }

}
