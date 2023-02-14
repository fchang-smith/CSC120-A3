

public class Test {
    public static void main(String[] args) {
        String s = ("bb cb,bb.bbb");
        String[] n = s.split("[, ]", 0);
        for (int i =0; i<n.length;i++){
            System.out.println(n[i]);
        }
    }
}
