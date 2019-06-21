package sliit.report.countroller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MainCountroller {

    public TextField searchText;

    public void SearchOrderDetails(ActionEvent keyEvent) throws ClassNotFoundException, JRException, SQLException {

        String id = searchText.getText();
        File file = new File("Report/sssss.jasper");
        System.out.println(file.getAbsoluteFile());
        JasperReport compileReport = (JasperReport) JRLoader.loadObject(file);

        DefaultTableModel dtm = new DefaultTableModel(new Object[]{"ID","NAME1","ADDRESS","TEL"},0);

        Map<String,Object> params = new HashMap<>();
        params.put("itemId",id);

        Class.forName("com.mysql.jdbc.Driver");

        JasperPrint filledReport = JasperFillManager.fillReport(compileReport,params, DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root"));

        JasperViewer.viewReport(filledReport,false);

    }


}
