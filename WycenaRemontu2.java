import javax.swing.JOptionPane;

public class WycenaRemontu2 {

    public static void main(String[] args) {
        double szerokosc = Double.parseDouble(JOptionPane.showInputDialog("Enter the width of the room (in meters):"));
        double dlugosc = Double.parseDouble(JOptionPane.showInputDialog("Enter the length of the room (in meters):"));
        double wysokosc = Double.parseDouble(JOptionPane.showInputDialog("Enter the height of the room (in meters):"));

        double powierzchniaPodlogi = szerokosc * dlugosc;
        double powierzchniaScian = 2 * (szerokosc + dlugosc) * wysokosc;
        double powierzchniaSufitu = szerokosc * dlugosc;
        double obwodPokoju = 2 * (szerokosc + dlugosc);


        int gipsowanieOption = JOptionPane.showConfirmDialog(null, "Do you want to plaster your walls?", "Service selection", JOptionPane.YES_NO_OPTION);
        int malowanieOption = JOptionPane.showConfirmDialog(null, "Do you want to paint the walls and ceiling?", "Service selection", JOptionPane.YES_NO_OPTION);
        int paneleOption = JOptionPane.showConfirmDialog(null, "Do you want to lay floor panels?", "Service selection", JOptionPane.YES_NO_OPTION);
        int listwyOption = JOptionPane.showConfirmDialog(null, "Do you want to lay skirting boards?", "Service selection", JOptionPane.YES_NO_OPTION);

        double kosztCalkowity = 0.0;

        if (gipsowanieOption == JOptionPane.YES_OPTION) {
            double kosztGipsowania = powierzchniaScian * 100.0;
            kosztCalkowity += kosztGipsowania;
        }

        if (malowanieOption == JOptionPane.YES_OPTION) {
            double kosztMalowania = (powierzchniaScian + powierzchniaSufitu) * 30.0;
            kosztCalkowity += kosztMalowania;
        }

        if (paneleOption == JOptionPane.YES_OPTION) {
            double kosztPaneliPodlogowych = powierzchniaPodlogi * 50.0;
            kosztCalkowity += kosztPaneliPodlogowych;
        }

        if (listwyOption == JOptionPane.YES_OPTION) {
            double kosztListewPrzypodlogowych = obwodPokoju * 40.0;
            kosztCalkowity += kosztListewPrzypodlogowych;
        }

        JOptionPane.showMessageDialog(null, "Estimated cos of renovation works: " + kosztCalkowity + " zł");
    }
}
