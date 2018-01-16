package javaEnhance;

import java.util.Date;
import java.util.Objects;

/**
 * Created by deng on 18/1/14.
 */
public class ReflectPoint {
    private Date birthday = new Date();

    private int x;
    public int y;

    public String st1 = "ball";
    public String st2 = "basketball";
    public String st3 = "computer";

    public ReflectPoint(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReflectPoint that = (ReflectPoint) o;

        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return st1+":"+st2+":"+st3;
    }
}
