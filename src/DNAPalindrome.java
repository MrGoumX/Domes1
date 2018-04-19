public class DNAPalindrome {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(" is Watson-Crick complemented palindrome");
        } else {
            if (args[0].matches("[ATGC]+")) {
                String checkPal = args[0];
                CharDoubleEndedQueueImpl<Character> dna = new CharDoubleEndedQueueImpl<Character>();
                for (char palChar : checkPal.toCharArray()) {
                    if (palChar == 'A')
                      dna.addFirst('T');
                    else if (palChar == 'T')
                      dna.addFirst('A');
                    else if (palChar == 'G')
                      dna.addFirst('C');
                    else
                      dna.addFirst('G');
                }
                char[] finalPal = new char[dna.size()];
                for(int i = 0; i < checkPal.length(); i++) {
                    finalPal[i] = dna.removeFirst();
                }
                String finalPalS = String.copyValueOf(finalPal);
                if (finalPalS.equals(checkPal)) {
                    System.out.println(checkPal + " is Watson-Crick complemented palindrome");
                } else {
                    System.out.println(checkPal + " is not Watson-Crick complemented palindrome");
                }
            } else {
                System.err.println("You did not gave a valid string");
                System.exit(1);
            }
        }
    }
}
