import java.io.IOException;

/**
 * Command factory which creates new instances of each potential decryption (potentially
 * encryption for future) and calls that method's required methods so as to abstract out
 * concerns.
 */
class CommandFactory {

    void anagram() throws IOException {
        AnagramHash ah = new AnagramHash();
        ah.execute();
    }

    void keyword() throws IOException {
        Keyword k = new Keyword();
        k.execute();
    }

    void shift() throws IOException {
        Shift s = new Shift();
        s.execute();
    }

    void automate() throws IOException {
        Automate au = new Automate();
        au.execute();
    }
}
