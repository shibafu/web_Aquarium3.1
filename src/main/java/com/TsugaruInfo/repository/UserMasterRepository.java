package com.TsugaruInfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TsugaruInfo.entity.UserMaster;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Integer> {
    public UserMaster findByUsername(String usernamename);
    public UserMaster findByEmail(String email);
    public List<UserMaster> findByEnabled(Boolean enabled);
}
