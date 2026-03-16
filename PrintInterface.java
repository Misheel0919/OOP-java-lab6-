import java.awt.*;
import javax.swing.*;

public class PrintInterface extends JFrame {

    JComboBox<String> destinationBox;
    JComboBox<String> pagesBox;
    JComboBox<String> layoutBox;
    JComboBox<String> colourBox;

    public PrintInterface() {
        setTitle("Print");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(createPreviewSection(), BorderLayout.CENTER);
        add(createSettingsSection(), BorderLayout.EAST);
    }

    private JPanel createPreviewSection() { // Zuun taliin heseg
        JPanel preview = new JPanel(new GridBagLayout());
        preview.setBackground(Color.GRAY);

        JLabel fileLabel = new JLabel("+ Enter file");
        fileLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        fileLabel.setForeground(Color.LIGHT_GRAY);

        preview.add(fileLabel);
        return preview;
    }

    private JPanel createSettingsSection() { // Baruun taliin settings panel
        JPanel settings = new JPanel();
        settings.setPreferredSize(new Dimension(300, 500));
        settings.setBackground(Color.DARK_GRAY);
        settings.setLayout(null);

        JLabel title = new JLabel("Print");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.PLAIN, 24));
        title.setBounds(20, 20, 100, 30);
        settings.add(title);

        addLabel(settings, "Destination", 20, 70);
        destinationBox = addCombo(settings, new String[]{"Microsoft Print to PDF"}, 20, 95);

        addLabel(settings, "Pages", 20, 145);
        pagesBox = addCombo(settings, new String[]{"All", "Current Page", "Custom"}, 20, 170);

        addLabel(settings, "Layout", 20, 220);
        layoutBox = addCombo(settings, new String[]{"Portrait", "Landscape"}, 20, 245);

        addLabel(settings, "Colour", 20, 295);
        colourBox = addCombo(settings, new String[]{"Colour", "Black & White"}, 20, 320);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 380, 300, 1);
        separator.setForeground(Color.GRAY);
        settings.add(separator);

        JButton printBtn = new JButton("Print");
        printBtn.setBounds(70, 430, 90, 35);
        printBtn.addActionListener(e -> {
            System.out.println("    Selected Options    ");
            System.out.println("Destination: " + destinationBox.getSelectedItem());
            System.out.println("Pages: " + pagesBox.getSelectedItem());
            System.out.println("Layout: " + layoutBox.getSelectedItem());
            System.out.println("Colour: " + colourBox.getSelectedItem());
            System.out.println();
            JOptionPane.showMessageDialog(this, "Printed!");
        });
        settings.add(printBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(170, 430, 90, 35);
        cancelBtn.addActionListener(e -> {
            System.out.println("Cancelled");
            JOptionPane.showMessageDialog(this, "Cancelled!");
        });
        settings.add(cancelBtn);

        return settings;
    }

    private void addLabel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(x, y, 200, 20);
        panel.add(label);
    }

    private JComboBox<String> addCombo(JPanel panel, String[] items, int x, int y) {
        JComboBox<String> combo = new JComboBox<>(items);
        combo.setBounds(x, y, 250, 30);
        combo.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(combo);
        return combo;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PrintInterface().setVisible(true);
        });
    }
}