package com.fhfelipe.jasperreportflow.repository;

import com.fhfelipe.jasperreportflow.model.ReportUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportUser, Integer> {

  @Override
  Optional<ReportUser> findById(Integer integer);

  ReportUser save(ReportUser reportUser);

}
