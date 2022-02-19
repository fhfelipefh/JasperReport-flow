package com.fhfelipe.jasperreportflow.controller;


import com.fhfelipe.jasperreportflow.service.InvoiceService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {

  private final InvoiceService invoiceService;
  private static final String JRXML_FILE = "src/main/resources/jasper-input/invoice.jrxml";

  @Autowired
  private InvoiceController(InvoiceService invoiceService) {
    this.invoiceService = invoiceService;
  }

  @GetMapping("pdf")
  public ResponseEntity<byte []> getPdf() throws FileNotFoundException, JRException {

    JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(invoiceService.createInDBAndReturnReportUsers());
    JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream(JRXML_FILE));

    //guarda parâmetros definidos como: <nome do parâmetro,informação>
    HashMap<String, Object> parameters = new HashMap<>();
    parameters.put("footertext", "by felipe");

    JasperPrint report = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

    //trecho para gerar arquivo na máquina
    //JasperExportManager.exportReportToPdfFile(report, "invoice.pdf");

    byte[] pdf = JasperExportManager.exportReportToPdf(report);
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=invoice.pdf");
    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(pdf);
  }

  @GetMapping("delete")
  public ResponseEntity<String> deleteAll() {
    invoiceService.deleteAll();
    return ResponseEntity.ok().body("All Data Deleted");
  }


}
