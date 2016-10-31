package service;

import entity.CpInfo;
import entity.ProductInfo;

import java.util.List;

/**
 * Created by Ridiculous on 2016/5/27.
 */
public interface configureService {
    int addCpUser(CpInfo cpinfo);
    int updateCpUser(CpInfo cpinfo);
    int deleteCpUserById(int id);
    CpInfo getUserbyId(int id);
    List<CpInfo> getAllCpInfos();
}
