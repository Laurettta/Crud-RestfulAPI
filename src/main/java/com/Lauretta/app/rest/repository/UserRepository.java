package com.Lauretta.app.rest.repository;

import com.Lauretta.app.rest.controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Long> {
}
