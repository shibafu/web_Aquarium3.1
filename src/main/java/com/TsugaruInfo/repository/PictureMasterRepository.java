package com.TsugaruInfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TsugaruInfo.entity.PictureMaster;
import com.TsugaruInfo.entity.UserMaster;

@Repository
public interface PictureMasterRepository extends JpaRepository<PictureMaster, Integer> {


    public PictureMaster findByPictureId(Integer pictureId);
    public PictureMaster findByPictureName(String pictureName);
    
    //Likeであいまい検索
//    public List<UserMaster> findByUsernameLike(String usernamename);
//    public List<UserMaster> findByEmailLike(String email);
    
//    @Query("SELECT count(*) From UserMaster u WHERE u.username = :username")
//    public int countByUsername(@Param("username")String username);
}
