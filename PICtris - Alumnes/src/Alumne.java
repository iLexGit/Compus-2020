import com.fazecast.jSerialComm.SerialPort;

import javax.management.remote.rmi.RMIServerImpl_Stub;
import java.nio.Buffer;

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



        String GameOverMsg = new String("Game Over");

        if ((GameOverMsg.length()%2) == 0){
            GameOverMsg = GameOverMsg + "*";
        }else{
            GameOverMsg = GameOverMsg + " *";
        }

        byte[] message = GameOverMsg.getBytes();

        System.out.println(message);

        String recovered = new String(message);
        System.out.println(recovered);


        serialPort.writeBytes(message, message.length);


    }
}
