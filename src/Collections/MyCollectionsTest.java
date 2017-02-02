package Collections;

import java.util.*;

/**
 * Created by Minsuk_Heo on 1/1/2017.
 */
public class MyCollectionsTest {
    public static void main(String[] args) {
        List<Integer> arrayList1 = new ArrayList<Integer>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);

        Iterator itr = arrayList1.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        ListIterator litr = arrayList1.listIterator();
        while(litr.hasNext()){
            System.out.println(litr.next());
        }
        while(litr.hasPrevious()){
            System.out.println(litr.previous());
        }
        System.out.println("hashset test");
        Set<Integer> s = new HashSet<Integer>();
        s.add(1);
        s.add(1);
        s.add(2);
        itr = s.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("tree set test");
        Set<Integer> ts = new TreeSet<Integer>();
        ts.add(1);
        ts.add(1);
        ts.add(5);
        ts.add(3);
        itr = ts.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
