package service;

import entity.CpInfo;

import java.util.List;

/**
 * Created by Ridiculous on 2016/5/27.
 */
public interface configureService {
    int addCpUser(CpInfo cpinfo);
    int updateCpUser(CpInfo cpinfo);
    int deleteCpUserById(int id);
    int updatePrivilegebyId(int id, Byte level);
    CpInfo getUserbyId(int id);
    List<CpInfo> getAllCpInfos();
}
