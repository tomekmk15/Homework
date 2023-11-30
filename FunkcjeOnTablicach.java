package zadania;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FunkcjeOnTablicach {

    public static void main(String[] args) {
        int[] tablica = {2, 5, 7, 9, 12};
        int[] tablica2 = {3, 6, 8, 9, 11};

        wypiszPodzielne(tablica, 3);

        Integer pierwsza = pierwszaPodzielna(tablica, 5);

        System.out.println("First divisible by 5: " + pierwsza);

        int suma = sumaPodzielnych(tablica, 3);

        System.out.println("Sum divisible by 3:" + suma);

        int ile = ilePodzielnych(tablica, 2);

        System.out.println("Number of divisible by 2: " + ile);

        double srednia = sredniaPodzielnych(tablica, 3);

        System.out.println("Average divisible by 3: " + srednia);

        Integer max = max(tablica);

        System.out.println("The greatest value: " + max);

        Integer min = min(tablica);

        System.out.println("Smallest value: " + min);

        int roznica = roznicaMinMax(tablica);

        System.out.println("Difference between largest and smallest number: " + roznica);

        Integer wspolny = znajdzWspolny(tablica, tablica2);

        System.out.println("Common element: " + wspolny);

        List<Integer> wszystkieWspolneList = wszystkieWspolne(tablica, tablica2);
        
        System.out.println("All common element " + wszystkieWspolneList);
    }

    public static void wypiszPodzielne(int[] tab, int x) {
        System.out.print("Numbers divisible by" + x + ": ");
        for (int num : tab) {
            if (num % x == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static Integer pierwszaPodzielna(int[] tab, int x) {
        for (int num : tab) {
            if (num % x == 0) {
                return num;
            }
        }
        return null;
    }

    public static int sumaPodzielnych(int[] tab, int x) {
        int sum = 0;
        for (int num : tab) {
            if (num % x == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static int ilePodzielnych(int[] tab, int x) {
        int count = 0;
        for (int num : tab) {
            if (num % x == 0) {
                count++;
            }
        }
        return count;
    }

    public static double sredniaPodzielnych(int[] tab, int x) {
        int sum = 0;
        int count = 0;
        for (int num : tab) {
            if (num % x == 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            return 0; // Aby uniknąć dzielenia przez zero, gdy nie ma żadnych podzielnych liczb
        }
        return (double) sum / count;
    }

    public static Integer max(int[] tab) {
        if (tab.length == 0) {
            return null;
        }
        int max = tab[0];
        for (int num : tab) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static Integer min(int[] tab) {
        if (tab.length == 0) {
            return null;
        }
        int min = tab[0];
        for (int num : tab) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int roznicaMinMax(int[] tab) {
        if (tab.length == 0) {
            return 0;
        }
        int min = tab[0];
        int max = tab[0];
        for (int num : tab) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }
        return max - min;
    }

    public static Integer znajdzWspolny(int[] t1, int[] t2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : t1) {
            set.add(num);
        }
        for (int num : t2) {
            if (set.contains(num)) {
                return num;
            }
        }
        return null;
    }

    public static List<Integer> wszystkieWspolne(int[] t1, int[] t2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> wspolneElementy = new ArrayList<>();
        for (int num : t1) {
            set.add(num);
        }
        for (int num : t2) {
            if (set.contains(num)) {
                wspolneElementy.add(num);
            }
        }
        return wspolneElementy;
    }
}