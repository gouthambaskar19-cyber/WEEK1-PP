public class ReverseCustomerName {

    public static void main(String[] args) {
        String[] inputs = {"Sunil", "Baskar", "Anand"};

        for (String customerName : inputs) {
            String reversedName = reverseCustomerName(customerName);
            System.out.println("Original Name: " + customerName);
            System.out.println("Reversed Name: " + reversedName);
            System.out.println();
        }
    }

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        char[] reversed = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }

        return new String(reversed);
    }
}
