package service;

import entity.CpInfo;

import java.util.List;

/**
 * Created by Ridiculous on 2016/5/27.
 */
public interface configureService {
    int addCpUser(CpInfo cpinfo);
    //int deleteCpUserById(int id);
    int updatePrivilegebyId(int id, Byte level);
    List<CpInfo> getAllCpUser();
    CpInfo getUserbyId(int id);
}
