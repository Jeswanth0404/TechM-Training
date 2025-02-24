public class task_5 {
    public static void main(String[] args) {
        String input = "hello world";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            result.append(i % 2 == 0 ? Character.toUpperCase(c) : c);
        }

        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result.toString());
    }
}
