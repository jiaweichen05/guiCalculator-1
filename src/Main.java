public class Main {
    public static void main(String[] args) {
        GUI guiCalc = new GUI();
        guiCalc.setSize(350,300);
        guiCalc.setLocationRelativeTo(null);
        guiCalc.setVisible(true);
        guiCalc.setGUITitle("GUI Calculator");
        System.out.println(guiCalc.getTitle());
    }
}
