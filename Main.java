public static int decode(String input) {
    HashMap<Integer, String> map = new HashMap<>();
    for (int i = 1; i <= 26; i++) {
        map.put(i, Character.toString((char) ('A' + i - 1)));
    }

    int len = input.length();
    int[] combinations = new int[len];
    combinations[0] = 1;

    for (int i = 1; i < len; i++) {
        int num1 = Integer.parseInt(Character.toString(input.charAt(i - 1)));
        int num2 = Integer.parseInt(Character.toString(input.charAt(i)));

        if (num1 == 0 || num2 == 0) {
            combinations[i] = combinations[i - 1];
            if (last != i - 1) {
                return 0;
            }
        } else {
            combinations[i] = combinations[i - 1];
            int combinedNum = num1 * 10 + num2;
            if (combinedNum <= 26) {
                combinations[i] += combinations[last];
                last = i - 1;
            }
        }
    }

    return combinations[len - 1];
}
