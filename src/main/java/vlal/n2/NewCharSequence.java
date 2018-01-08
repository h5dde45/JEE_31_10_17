package vlal.n2;

public interface NewCharSequence {
    int length();

    char charAt(int i);

    NewCharSequence subSequence(int start, int end);

    default NewCharSequence subSequence(int start) {
        return subSequence(start, length());
    }


}
