public class Main {
    public static void main(String[] args) {
        new Main().method('c');
    }

    public void method(byte b) {
        System.out.println("byte");
    }

    public void method(int i) {
        System.out.println("integer");
    }
}
