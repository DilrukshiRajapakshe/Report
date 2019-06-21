package sliit.jasper.countroller;

import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.repo.FileRepositoryPersistenceServiceFactory;
import net.sf.jasperreports.repo.FileRepositoryService;
import net.sf.jasperreports.repo.PersistenceServiceFactory;
import net.sf.jasperreports.repo.RepositoryService;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

public class jasperCountroller {

    public void ShowReport(ActionEvent actionEvent) throws JRException {
        JasperDesign javaDesign = JRXmlLoader.load(this.getClass().getResourceAsStream("/sliit/jasper/report/hello.jrxml"));
        JasperReport compileReport = JasperCompileManager.compileReport(javaDesign);
        JasperPrint javaReport = JasperFillManager.fillReport(compileReport, new HashMap<>(), new JREmptyDataSource());
        JasperViewer.viewReport(javaReport);
    }

    public void ShowFile(ActionEvent actionEvent) throws JRException {
        File f = new File("Report/Extanal.jrxml");
        System.out.println(f.getAbsoluteFile());
        JasperDesign javaDesign = JRXmlLoader.load(f);
        JasperReport compileReport = JasperCompileManager.compileReport(javaDesign);
        JasperPrint javaReport = JasperFillManager.fillReport(compileReport, new HashMap<>(), new JREmptyDataSource());
        JasperViewer.viewReport(javaReport);

    }

    public void ShowObject(ActionEvent actionEvent) throws JRException {
        //Extanal.jasper
        File f = new File("Report/Extanal.jasper");
        JasperReport compileReport = (JasperReport) JRLoader.loadObject(f);
        JasperPrint javaReport = JasperFillManager.fillReport(compileReport, new HashMap<>(), new JREmptyDataSource());
        JasperViewer.viewReport(javaReport);
    }

    public void ShowButtonReport(ActionEvent actionEvent) throws JRException {

        SimpleJasperReportsContext sjrc = new SimpleJasperReportsContext();
        File f = new File("Report");
        FileRepositoryService frs = new FileRepositoryService(sjrc, f.getAbsolutePath(),false);
        sjrc.setExtensions(RepositoryService.class, Collections.singletonList(frs));
        sjrc.setExtensions(PersistenceServiceFactory.class,Collections.singletonList(FileRepositoryPersistenceServiceFactory.getInstance()));
        File jas = new File("Report/Sewwandi.jasper");
        JasperReport cp = (JasperReport)JRLoader.loadObject(sjrc,jas);
        JasperPrint file = JasperFillManager.getInstance(sjrc).fill(cp,new HashMap<>(),new JREmptyDataSource());
        JasperViewer.viewReport(file,false);


    }
}
