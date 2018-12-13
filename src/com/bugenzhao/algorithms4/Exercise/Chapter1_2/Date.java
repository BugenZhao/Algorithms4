package com.bugenzhao.algorithms4.Exercise.Chapter1_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Date {

    public final int month;
    public final int day;
    public final int year;

    public Date(String date_str) {
        String[] fields = date_str.split("/| |,");
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public boolean equals(Object x) {
        if (this == x) {
            return true;
        }
        if (x == null) {
            return false;
        }
        if (this.getClass() != x.getClass()) {
            return false;
        }
        Date that = (Date) x;
        if (this.day != that.day) {
            return false;
        }
        if (this.month != that.month) {
            return false;
        }
        if (this.year != that.year) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str;
        Date bz_date = new Date("10 18 2000");
        while (true) {
            str = StdIn.readLine();
            Date date = new Date(str);
            StdOut.println(date);
            StdOut.println(date.equals(bz_date));
        }
    }
}
