package zadania;

public class Range {

    public static void main(String[] args) {
        int start = 0;
        int end = 0;
        int step = 1;

        if (args.length >= 1) {
            start = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                end = Integer.parseInt(args[1]);
                if (args.length >= 3) {
                    step = Integer.parseInt(args[2]);
                }
            }
        }

        printRange(start, end, step);
    }

    public static void printRange(int start, int end, int step) {
        if (step > 0) {
            for (int i = start; i < end; i += step) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = start; i > end; i += step) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
