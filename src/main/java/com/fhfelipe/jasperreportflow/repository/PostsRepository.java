package com.fhfelipe.jasperreportflow.repository;

import com.fhfelipe.jasperreportflow.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<UserPost, Integer> {

}
