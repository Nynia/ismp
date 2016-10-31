package service.impl;
import dao.CpInfoMapper;
import dao.ProductInfoMapper;
import entity.CpInfo;
import entity.ProductInfo;
import org.springframework.stereotype.Service;
import service.configureService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Ridiculous on 2016/5/27.
 */
@Service
public class configureServiceImpl implements configureService {

    @Resource
    private CpInfoMapper mapper;

    public int addCpUser(CpInfo cpinfo) {
        return mapper.insert(cpinfo);
    }

    public int updateCpUser(CpInfo cpinfo) {
        return mapper.updateByPrimaryKey(cpinfo);
    }

    public int deleteCpUserById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    //    public int deleteCpUserById(int id) {
//        return mapper.deleteByPrimaryKey(id);
//    }
//
//
    public CpInfo getUserbyId(int id) {
        return mapper.selectByPrimaryKey(id);
    }



    public List<CpInfo> getAllCpInfos() {
        return mapper.selectAllCpInfos();
    }
}
