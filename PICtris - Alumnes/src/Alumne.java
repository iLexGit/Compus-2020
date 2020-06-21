import com.fazecast.jSerialComm.SerialPort;

import javax.management.remote.rmi.RMIServerImpl_Stub;
import java.nio.Buffer;

public class Alumne {

    public static final int TIME_WAIT_MS = 10;

    public static void sendFramebuffer(PICtris pictris, SerialPort serialPort) {
        byte[] framebuffer = pictris.getFrameBuffer();
        // Write your code here

    }

    public static void getInput(PICtris pictris, SerialPort serialPort) {
        //System.out.println("getInput");
         //String RX_char = serialPort.readBytes(RX_buffer, 8);
        byte[] RX_buffer = new byte[1];
        serialPort.readBytes(RX_buffer, 1);

        String RX_String = new String(RX_buffer);


        if (RX_String.equals("W")){
            System.out.println(RX_String + "\themos recibido una W = Rotate");
        }

        if (RX_String.equals("A")){
            System.out.println(RX_String + "\themos recibido una A = Left");
        }

        if (RX_String.equals("S")){
            System.out.println(RX_String + "\themos recibido una S = Down");
        }

        if (RX_String.equals("D")){
            System.out.println(RX_String + "\themos recibido una D = Right");
        }

        if (RX_String.equals("B")){
            System.out.println(RX_String + "\themos recibido una B = Drop to bottom");
        }




        /* Example code:
           pictris.move(-1); // Moves the current piece 1 block to the left
           pictris.move(1); // Moves the current piece 1 block to the right
           pictris.rotate(); // Rotates the current piece
           pictris.userDropDown(); // Drops the current piece 1 position
           pictris.hardDrop(); // Drops the current piece to bottom
         */
        //SerialPort.getCommPort("HOLA ALEJANDRO");

        // Write your code here

    }


    public static void gameOver(PICtris pictris, SerialPort serialPort) {
        int score = pictris.getScore();

        // Write your code here

    }
}
