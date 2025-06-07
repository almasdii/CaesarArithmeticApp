package day1;

public class Caeser {

    private static final String ENG_LOW = "abcdefghijklmnopqrstuvwxyz";
    private static final String ENG_UP  = ENG_LOW.toUpperCase();
    private static final String RUS_LOW = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String RUS_UP  = RUS_LOW.toUpperCase();

    public static String encrypt(String text, int shift)  {
        return shift(text,  shift);
    }
    public static String decrypt(String text, int shift)  {
        return shift(text, -shift);
    }


    private static String shift(String text, int shift) {
        StringBuilder sb = new StringBuilder(text.length());

        for (char ch : text.toCharArray()) {
            sb.append(shiftChar(ch, shift));
        }
        return sb.toString();
    }

    private static char shiftChar(char ch, int shift) {
        int idx;
        if ((idx = ENG_LOW.indexOf(ch)) != -1)
            return ENG_LOW.charAt(mod(idx + shift, ENG_LOW.length()));
        if ((idx = ENG_UP.indexOf(ch)) != -1)
            return ENG_UP.charAt(mod(idx + shift, ENG_UP.length()));
        if ((idx = RUS_LOW.indexOf(ch)) != -1)
            return RUS_LOW.charAt(mod(idx + shift, RUS_LOW.length()));
        if ((idx = RUS_UP.indexOf(ch)) != -1)
            return RUS_UP.charAt(mod(idx + shift, RUS_UP.length()));

        return ch;
    }

    private static int mod(int a, int m) {
        int r = a % m;
        return r < 0 ? r + m : r;
    }
}
