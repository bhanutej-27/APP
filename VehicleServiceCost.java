import javax.swing.*;
import java.awt.*;

class ServiceModel {

    public int calculate(boolean general,
                         boolean oil,
                         boolean brake,
                         boolean battery) {

        int total = 0;

        if (general)
            total += 1000;

        if (oil)
            total += 800;

        if (brake)
            total += 1200;

        if (battery)
            total += 500;

        return total;
    }
}

class ServiceView extends JFrame {

    JTextField reg = new JTextField(15);

    JComboBox<String> type =
        new JComboBox<>(new String[]{
            "Two Wheeler",
            "Car"
        });

    JCheckBox general =
        new JCheckBox("General Service - Rs.1000");

    JCheckBox oil =
        new JCheckBox("Oil Change - Rs.800");

    JCheckBox brake =
        new JCheckBox("Brake Service - Rs.1200");

    JCheckBox battery =
        new JCheckBox("Battery Check - Rs.500");

    JButton calculate =
        new JButton("Calculate Cost");

    JLabel result =
        new JLabel("Total: Rs.0");

    ServiceView() {

        setTitle("Vehicle Service Cost Estimator");

        setLayout(new GridLayout(9, 1));

        add(new JLabel("Registration Number:"));
        add(reg);
        add(type);
        add(general);
        add(oil);
        add(brake);
        add(battery);
        add(calculate);
        add(result);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

class ServiceController {

    ServiceController(ServiceModel model,
                      ServiceView view) {

        view.calculate.addActionListener(e -> {

            int cost = model.calculate(
                view.general.isSelected(),
                view.oil.isSelected(),
                view.brake.isSelected(),
                view.battery.isSelected()
            );

            view.result.setText(
                "Total Service Cost: Rs." + cost
            );
        });
    }
}

public class VehicleServiceCost {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ServiceModel model =
                new ServiceModel();

            ServiceView view =
                new ServiceView();

            new ServiceController(model, view);

            view.setVisible(true);
        });
    }
}