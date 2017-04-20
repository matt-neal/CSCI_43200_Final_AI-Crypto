import java.io.IOException;

/**
 * Command factory which creates new instances of each potential decryption (potentially
 * encryption for future) and calls that method's required methods so as to abstract out
 * concerns.
 */
class CommandFactory {

    void anagram() throws IOException {
        try {
            AnagramHash ah = new AnagramHash();
            ah.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void shift() throws IOException {
        try {
            Shift s = new Shift();
            s.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void shiftEncrypt() throws IOException {
        try {
            Shift s = new Shift();
            s.executeEncrypt();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void automate() throws IOException {
        try {
            Automate au = new Automate();
            au.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}