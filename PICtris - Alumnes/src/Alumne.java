import com.fazecast.jSerialComm.SerialPort;
import com.sun.source.tree.Scope;

import javax.management.remote.rmi.RMIServerImpl_Stub;
import java.io.StreamCorruptedException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Alumne {

    public static final int TIME_WAIT_MS = 10;

    public static void sendFramebuffer(PICtris pictris, SerialPort serialPort) {
        byte[] framebuffer = pictris.getFrameBuffer();
        //String s = new String(framebuffer);
        serialPort.writeBytes(framebuffer, framebuffer.length);
        
//        System.out.println("------------------------------------");
//        for (int i=0; i<16; i++){
//            System.out.println(framebuffer[i]);
//        }
        // Write your code here
    }

    public static void getInput(PICtris pictris, SerialPort serialPort) {
        byte[] RX_buffer = new byte[1];
        serialPort.readBytes(RX_buffer, 1);

        String RX_String = new String(RX_buffer);


        if (RX_String.equals("W")){
            System.out.println(RX_String + "\themos recibido una W = Rotate");
            pictris.rotate();
        }

        if (RX_String.equals("A")){
            System.out.println(RX_String + "\themos recibido una A = Left");
            pictris.move(-1);
        }

        if (RX_String.equals("S")){
            System.out.println(RX_String + "\themos recibido una S = Down");
            pictris.userDropDown();
        }

        if (RX_String.equals("D")){
            System.out.println(RX_String + "\themos recibido una D = Right");
            pictris.move(+1);
        }

        if (RX_String.equals("B")){
            System.out.println(RX_String + "\themos recibido una B = Drop to bottom");
            pictris.hardDrop();
        }

    }


    public static void gameOver(PICtris pictris, SerialPort serialPort) {
        int score = pictris.getScore();

        String score_String =  String.valueOf(score);

        if(score <10){
            score_String = "000" + score_String;
        }else if(score<100){
            score_String = "00" + score_String;
        }else if (score < 1000){
            score_String = "0" + score_String;
        }

        //byte[] score_byte = score_String.getBytes();

        String GameOverMsg = new String("HAS PERDIDO POR TONTO");

//        if ((GameOverMsg.length()%2) == 0){
//            GameOverMsg = GameOverMsg + " "; //doble espai
//        }

        GameOverMsg = "*" + GameOverMsg + "*" + score_String + "*";

        byte[] GameOverMsg_byte = GameOverMsg.getBytes();

        serialPort.writeBytes(GameOverMsg_byte, GameOverMsg_byte.length);

    }
}
