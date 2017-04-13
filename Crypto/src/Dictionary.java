import java.awt.*;
import java.io.*;
import java.util.*;

abstract class Dictionary {
    File dict = new File("dict.txt");
    Object words;
    int avgIndex = 1;

    abstract public boolean contains(String word);

}