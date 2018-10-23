package com.TsugaruInfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TsugaruInfo.entity.PictureMaster;

@Repository
public interface PictureMasterRepository extends JpaRepository<PictureMaster, Integer> {

    public PictureMaster findByPictureId(Long pictureId);
    public PictureMaster findByPictureName(String pictureName);

    public List<PictureMaster> findByUploadUserId(int uploadUserId);

    @Query("SELECT p From PictureMaster p"
    		+ " WHERE p.uploadUserId = :uploadUserId"
    		+ " AND ROWNUM = 9"
    		+ " ORDER BY p.uploadDate ASC")
    public List<PictureMaster> findLastUploadedPicture(@Param("uploadUserId")int uploadUserId);
    //Likeであいまい検索
//    public List<UserMaster> findByUsernameLike(String usernamename);
//    public List<UserMaster> findByEmailLike(String email);
}
