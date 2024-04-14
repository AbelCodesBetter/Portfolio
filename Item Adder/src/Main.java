import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main extends JFrame {
    private ArrayList<Item> itemList = new ArrayList<>();

    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel descriptionLabel;

    private JTextField nameField;
    private JTextField priceField;
    private JTextField descriptionField;

    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton viewButton;

    public Main() {
        setTitle("Item Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        nameLabel = new JLabel("Name:");
        priceLabel = new JLabel("Price:");
        descriptionLabel = new JLabel("Description:");

        nameField = new JTextField(20);
        priceField = new JTextField(20);
        descriptionField = new JTextField(20);

        addButton = new JButton("Add Item");
        deleteButton = new JButton("Delete Item");
        searchButton = new JButton("Search Item");
        viewButton = new JButton("View Items");

        addButton.setPreferredSize(new Dimension(120, 30));
        deleteButton.setPreferredSize(new Dimension(120, 30));
        searchButton.setPreferredSize(new Dimension(120, 30));
        viewButton.setPreferredSize(new Dimension(120, 30));

        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.WHITE);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        viewButton.setBackground(Color.BLACK);
        viewButton.setForeground(Color.WHITE);

        addButton.setFocusPainted(false);
        deleteButton.setFocusPainted(false);
        searchButton.setFocusPainted(false);
        viewButton.setFocusPainted(false);

        addButton.addMouseListener(new ButtonHoverEffect());
        deleteButton.addMouseListener(new ButtonHoverEffect());
        searchButton.addMouseListener(new ButtonHoverEffect());
        viewButton.addMouseListener(new ButtonHoverEffect());

        mainPanel.add(nameLabel, gbc);
        gbc.gridx++;
        mainPanel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(priceLabel, gbc);
        gbc.gridx++;
        mainPanel.add(priceField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(descriptionLabel, gbc);
        gbc.gridx++;
        mainPanel.add(descriptionField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(addButton, gbc);
        gbc.gridx++;
        mainPanel.add(deleteButton, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(searchButton, gbc);
        gbc.gridx++;
        mainPanel.add(viewButton, gbc);

        add(mainPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchItem();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewItems();
            }
        });
    }

    public void addItem() {
        try {
            String name = nameField.getText();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }

            double price = Double.parseDouble(priceField.getText());
            if (price <= 0) {
                throw new IllegalArgumentException("Price must be a positive number");
            }

            String description = descriptionField.getText();
            if (description.isEmpty()) {
                throw new IllegalArgumentException("Description cannot be empty");
            }

            Item newItem = new Item(name, price, description);
            itemList.add(newItem);
            JOptionPane.showMessageDialog(this, "Item added successfully");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid price format. Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteItem() {
        try {
            String name = nameField.getText();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }

            boolean found = false;
            for (Item item : itemList) {
                if (item.name.equalsIgnoreCase(name)) {
                    itemList.remove(item);
                    found = true;
                    JOptionPane.showMessageDialog(this, "Item deleted successfully");
                    clearFields();
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Item not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchItem() {
        try {
            String name = nameField.getText();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }

            boolean found = false;
            StringBuilder result = new StringBuilder();
            for (Item item : itemList) {
                if (item.name.equalsIgnoreCase(name)) {
                    result.append("Name: ").append(item.name).append("\n");
                    result.append("Price: ").append(item.price).append("\n");
                    result.append("Description: ").append(item.description).append("\n");
                    found = true;
                    break;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(this, result.toString(), "Search Result", JOptionPane.PLAIN_MESSAGE);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Item not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void viewItems() {
        if (itemList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items to view", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder result = new StringBuilder();
        for (Item item : itemList) {
            result.append("Name: ").append(item.name).append("\n");
            result.append("Price: ").append(item.price).append("\n");
            result.append("Description: ").append(item.description).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, result.toString(), "Items List", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    class Item {
        String name;
        double price;
        String description;

        public Item(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }
    }

    class ButtonHoverEffect extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(Color.BLACK);
        }
    }

    private void clearFields() {
        nameField.setText("");
        priceField.setText("");
        descriptionField.setText("");
    }

}
