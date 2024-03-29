package com.fhfelipe.jasperreportflow.service;

import com.fhfelipe.jasperreportflow.model.ReportUser;
import com.fhfelipe.jasperreportflow.model.UserPost;
import com.fhfelipe.jasperreportflow.repository.PostsRepository;
import com.fhfelipe.jasperreportflow.repository.ReportRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

  private final ReportRepository reportRepository;
  private final PostsRepository postsRepository;

  public InvoiceService(ReportRepository reportRepository, PostsRepository postsRepository) {
    this.reportRepository = reportRepository;
    this.postsRepository = postsRepository;
  }


  private String getRandomUsersNames() {
    int i = 6;
    String theAlphaNumericS;
    StringBuilder builder;

    theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    builder = new StringBuilder(i);

    for (int j = 0; j < i; j++) {
      builder.append(theAlphaNumericS.charAt((int) (Math.random() * theAlphaNumericS.length())));
    }
    return builder.toString();
  }

  public String getRandomNumber() {
    int i = 9;
    String theAlphaNumericS;
    StringBuilder builder;

    theAlphaNumericS = "0123456789";

    builder = new StringBuilder(i);

    for (int j = 0; j < i; j++) {
      builder.append(theAlphaNumericS.charAt((int) (Math.random() * theAlphaNumericS.length())));
    }
    return builder.toString();
  }

  public String getRandomEmail() {
    int i = 9;
    String theAlphaNumericS;
    StringBuilder builder;

    theAlphaNumericS = "0123456789";

    builder = new StringBuilder(i);

    for (int j = 0; j < i; j++) {
      builder.append(theAlphaNumericS.charAt((int) (Math.random() * theAlphaNumericS.length())));
    }
    return builder.toString() + "@gmail.com";
  }

  private int ramdomInt() {
    return (int) (Math.random() * 1000);
  }

  private List<ReportUser> generateUserList() {
    return Arrays.asList(
        new ReportUser(ramdomInt(), getRandomUsersNames(), getRandomUsersNames(), getRandomNumber(),
                       getRandomEmail(), "Felipe"),
        new ReportUser(ramdomInt(), getRandomUsersNames(), getRandomUsersNames(), getRandomNumber(),
                       getRandomEmail(), "Felipe"),
        new ReportUser(ramdomInt(), getRandomUsersNames(), getRandomUsersNames(), getRandomNumber(),
                       getRandomEmail(), "Felipe"));
  }

  public Collection<?> createInDBAndReturnReportUsers() {
    List<ReportUser> listToSave = generateUserList();

    if (listToSave.isEmpty()) {
      return Collections.emptyList();
    }

    for (ReportUser reportUser : listToSave) {
      reportRepository.save(reportUser);
      System.out.println("Saved: " + reportUser);
    }

    return reportRepository.findAll();
  }

  public Collection<?> findAll() {
    return reportRepository.findAll();
  }

  public void deleteAll() {
    reportRepository.deleteAll();
  }

  public Collection<?> createPosts() {
    if (postsRepository.findAll().size() < 30) {
      List<ReportUser> listUser = reportRepository.findAll();
      UserPost userPost = new UserPost();
      for (ReportUser reportUser : listUser) {
        userPost.setUserId(reportUser.getUserId());
        userPost.setId(ramdomInt());
        userPost.setTitle(getRandomUsersNames() + " teste nº " + ramdomInt());
        userPost.setBody(getRandomUsersNames() + getRandomUsersNames() + ", bem, só queria dizer isso mesmo.");
        postsRepository.save(userPost);
      }
    }
    return postsRepository.findAll();
  }

}
