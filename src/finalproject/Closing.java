package finalproject;

public class Closing {

    //Closing method to display a confirmation box before closing straightaway
    public static void close() {
        boolean close;
        close = ConfirmationBox.display("Confirmation", "Do you really want to close?");

        if (close == true) {
            System.exit(0);
        }

    }
}
