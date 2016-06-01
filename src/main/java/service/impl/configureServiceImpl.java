package service.impl;
import dao.CpInfoMapper;
import entity.CpInfo;
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

//    public int deleteCpUserById(int id) {
//        return mapper.deleteByPrimaryKey(id);
//    }
//
    public int updatePrivilegebyId(int id, Byte level) {
        CpInfo cp = mapper.selectByPrimaryKey(id);
        cp.setLevel(level);
        return mapper.updateByPrimaryKey(cp);
    }
//
    public List<CpInfo> getAllCpUser() {
        return mapper.selectAllCpUsers();
    }
//
    public CpInfo getUserbyId(int id) {
        return mapper.selectByPrimaryKey(id);
    }
}
