package com.fhfelipe.jasperreportflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JasperReportFlowApplication {

  public static void main(String[] args) {
    SpringApplication.run(JasperReportFlowApplication.class, args);

  }
}
