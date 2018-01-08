package vlal.n2;

@Version(value = "1.1", date = "2018-01-08")
public class CharSequenceImpl implements NewCharSequence {
    /*final*/ char[] chars;

//    public CharSequenceImpl(char[] chars) {
//        this.chars = chars;
//    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int i) {
        return chars[i];
    }

    @Override
    public NewCharSequence subSequence(int start, int end) {
        return new CharSequenceImpl();
    }
}
