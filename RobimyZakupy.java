import javax.swing.JOptionPane;

public class RobimyZakupy {
    public static void main(String[] args) {

        String cenaZiemniakowStr = JOptionPane.showInputDialog("Podaj cenę za kilogram ziemniaków:");
        double cenaZiemniakow = Double.parseDouble(cenaZiemniakowStr);


        double kosztZiemniakow = cenaZiemniakow * 5;


        JOptionPane.showMessageDialog(null, "Koszt 5 kilogramów ziemniaków wynosi: " + kosztZiemniakow);


        String pricePotato = JOptionPane.showInputDialog("Podaj cenę za kilogram ziemniakow:");
        double cenaziemniStr = Double.parseDouble(pricePotato);


        String ilosciZiemniakowStr = JOptionPane.showInputDialog("Ile kilogramów ziemniakow chcesz kupić:");
        double iloscZiemniakowStr = Double.parseDouble(ilosciZiemniakowStr);




        String cenaBananowStr = JOptionPane.showInputDialog("Podaj cenę za kilogram bananów:");
        double cenaBananow = Double.parseDouble(cenaBananowStr);


        String iloscBananowStr = JOptionPane.showInputDialog("Ile kilogramów bananów chcesz kupić:");
        double iloscBananow = Double.parseDouble(iloscBananowStr);




        double kosztBananow = cenaBananow * iloscBananow;


        double lacznyKoszt = kosztZiemniakow + kosztBananow;


        JOptionPane.showMessageDialog(null, "Koszt ziemniaków wynosi: " + kosztZiemniakow);
        JOptionPane.showMessageDialog(null, "Koszt bananów wynosi: " + kosztBananow);


        if (kosztZiemniakow > kosztBananow) {
            JOptionPane.showMessageDialog(null, "Za ziemniaki trzeba zapłacić więcej.");
        } else if (kosztBananow > kosztZiemniakow) {
            JOptionPane.showMessageDialog(null, "Za banany trzeba zapłacić więcej.");
        } else {
            JOptionPane.showMessageDialog(null, "Koszty za ziemniaki i banany są takie same.");
        }
    }
}
