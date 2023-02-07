import java.util.LinkedList;

public class Main {

    static class MyException extends Exception {
        public MyException(String strExc) {
            super(strExc);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> strList = new LinkedList<>();
        strList.add("유재석");
        strList.add("김종국");


        strList.forEach( (str)-> {
            try {
                if ( str.equals("유재석") ) {
                    System.out.println(str + " 당신은 국민엠씨입니다.");
                } else
                {
                    MyException exc = new MyException(str + " 당신은 국민엠씨가 아닙니다!!");
                    throw exc;
                }
            }catch (MyException myException) {
                System.out.println( myException.getMessage() );
            }
        } );

        String str = "test";
        System.out.println(str.compareTo("Test"));

        System.out.println();

        CompareMe me = new CompareMe(3);
        CompareMe another = new CompareMe(3);
        if ( me.equals(another) )
            System.out.println( "me와 another는 같습니다");
        else
            System.out.println( "me와 another는 다릅니다");

        if ( me == another )
            System.out.println( "me와 another는 같습니다");
        else
            System.out.println( "me와 another는 다릅니다");

    }
}

class CompareMe {
    int myNum = 0;
    public CompareMe(int num) {
        this.myNum = num;
    }

    @Override
    public boolean equals(Object obj) {

        if ( obj instanceof CompareMe )
        {
            CompareMe another = (CompareMe)obj;
            if ( this.myNum == another.myNum )
                return true;
        }

        return super.equals(obj);
    }
}