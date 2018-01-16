package javaEnhance;

/**
 * Created by deng on 18/1/13.
 */
public class EnumTest {
    public static void main(String[] args){
        WeekDay weekDay = WeekDay.FRI;
        System.out.println(weekDay);
        System.out.println(weekDay.name());
        System.out.println(weekDay.ordinal());
        System.out.println(WeekDay.valueOf("SUN").toString());
        System.out.println(WeekDay.values().length);
    }

    public enum WeekDay{
        SUN(1),MON(),TUE,WED,THI,FRI,SAT;
        private WeekDay(){
            System.out.println("first");
        }
        private WeekDay(int day){
            System.out.println("second");
        }
    }

    public enum TrafficLamp{
        RED(30){
            public TrafficLamp nextLamp(){
                return GREEN;
            }
        },
        GREEN(45){
            public TrafficLamp nextLamp(){
                return YELLOW;
            }
        },
        YELLOW(5){
            public TrafficLamp nextLamp(){
                return RED;
            }
        };
        public abstract TrafficLamp nextLamp();
        private int time;
        private TrafficLamp(int time){
            this.time = time;
        }
    }
}
