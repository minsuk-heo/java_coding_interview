package advanced;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by minsukheo on 2/18/17.
 */
public class Restaurant {
    ArrayList<Table> tableList;

    public static void main(String[] args) {
        Restaurant bj = new Restaurant();
        bj.makeReservation(new Reservation("John", "619-999-2222", 3, 12));
        bj.makeReservation(new Reservation("Bob", "619-999-2222", 3, 12));
        bj.makeReservation(new Reservation("Kim", "619-999-2222", 3, 12));
        bj.makeReservation(new Reservation("Jim", "619-999-2222", 3, 13));
        bj.makeReservation(new Reservation("Tom", "619-999-2222", 3, 12));
    }

    private void makeReservation(Reservation reservation) {
        for(Table table : tableList) {
            if (table.max >= reservation.totalMember) {
                if(!table.timeTable.schedule.get(reservation.time)) {
                    table.timeTable.schedule.put(reservation.time, true);
                    System.out.println("scheduled owithn "+table.max+"size table on "+reservation.time+ " for "+reservation.name);
                    return;
                }
            }
        }
        System.out.println("sorry, no available");
    }

    Restaurant() {
        tableList = new ArrayList<Table>();
        tableList.add(new Table(4));
        tableList.add(new Table(6));
        tableList.add(new Table(10));
    }
}

class Reservation{
    String name;
    String phone;
    int totalMember;
    int time;

    Reservation(String n, String p, int t, int i) {
        name = n;
        phone = p;
        totalMember = t;
        time = i;
    }
}

class Table {
    int max;
    TimeTable timeTable;

    Table(int n) {
        max = n;
        timeTable = new TimeTable();
    }
}

class TimeTable {
    HashMap<Integer, Boolean> schedule;

    TimeTable() {
        schedule = new HashMap<>();
        for(int i=0;i<24;i++) {
            schedule.put(i, false);
        }
    }
}