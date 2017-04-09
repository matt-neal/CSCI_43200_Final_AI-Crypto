/**
 * Main project file that initializes and begins the program.
 * For improved cohesion and reduced coupling, it calls the
 * Front Controller to begin functionality, this way if time
 * permits, it could be extended to run as a server for clients
 * to access and use remotely.
 */

public class Crypto {
    public static void main(String args[]){
        try {
            FrontController FC = new FrontController();
            FC.landingPage();
        }
        catch (Exception e) {
            System.out.println("Client Exception: " + e.getMessage());
            e.printStackTrace();
        }
        System.exit(0);
    }
}
