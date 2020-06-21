import com.fazecast.jSerialComm.SerialPort;

public class Alumne {

    public static final int TIME_WAIT_MS = 10;

    public static void sendFramebuffer(PICtris pictris, SerialPort serialPort) {
        byte[] framebuffer = pictris.getFrameBuffer();

        // Write your code here
        //Capullo

    }

    public static void getInput(PICtris pictris, SerialPort serialPort) {
        /* Example code:
           pictris.move(-1); // Moves the current piece 1 block to the left
           pictris.move(1); // Moves the current piece 1 block to the right
           pictris.rotate(); // Rotates the current piece
           pictris.userDropDown(); // Drops the current piece 1 position
           pictris.hardDrop(); // Drops the current piece to bottom
         */
        SerialPort.getCommPort("HOLA ALEJANDRO");

        // Write your code here

    }


    public static void gameOver(PICtris pictris, SerialPort serialPort) {
        int score = pictris.getScore();

        // Write your code here

    }
}
