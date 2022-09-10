package coding;


import java.time.LocalDateTime;

public class while_loop {


    public static void main(String[] args) throws InterruptedException {


        int startTime= LocalDateTime.now().getSecond();

//        System.out.println(LocalDateTime.now());

        System.out.println("start :" +startTime);

        while (startTime == LocalDateTime.now().getSecond()){

            System.out.println(LocalDateTime.now());
            Thread.sleep(100);
        }


        System.out.println("end : "+LocalDateTime.now().getSecond());


    }
}
