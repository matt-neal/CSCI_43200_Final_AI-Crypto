/**
 * Command factory which creates new instances of each potential decryption (potentially
 * encryption for future) and calls that method's required methods so as to abstract out
 * concerns.
 */
class CommandFactory {

    void anagram(){
        Anagram a = new Anagram();
        a.execute();
    }

    void keyword(){
        Keyword k = new Keyword();
        k.execute();
    }

    void shift(){
        Shift s = new Shift();
        s.execute();
    }

    void automate(){
        Automate au = new Automate();
        au.execute();
    }
}
