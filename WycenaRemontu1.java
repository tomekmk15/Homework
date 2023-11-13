import javax.swing.JOptionPane;

public class WycenaRemontu1 {

    public static void main(String[] args) {
        double szerokosc = Double.parseDouble(JOptionPane.showInputDialog("Enter the width of the room (in meters):"));
        double dlugosc = Double.parseDouble(JOptionPane.showInputDialog("Enter the length of the room (in meters):"));
        double wysokosc = Double.parseDouble(JOptionPane.showInputDialog("Enter the height of the room  (in meters):"));

        double powierzchniaPodlogi = szerokosc * dlugosc;
        double powierzchniaScian = 2 * (szerokosc + dlugosc) * wysokosc;
        double powierzchniaSufitu = szerokosc * dlugosc;
        double obwodPokoju = 2 * (szerokosc + dlugosc);

        double kosztGipsowania = powierzchniaScian * 100.0;
        double kosztMalowania = (powierzchniaScian + powierzchniaSufitu) * 30.0;
        double kosztPaneliPodlogowych = powierzchniaPodlogi * 50.0;
        double kosztListewPrzypodlogowych = obwodPokoju * 40.0;

        double kosztCalkowity = kosztGipsowania + kosztMalowania + kosztPaneliPodlogowych + kosztListewPrzypodlogowych;

        JOptionPane.showMessageDialog(null, "Estimated cost of renovation works: " + kosztCalkowity + " zł");
    }
}
