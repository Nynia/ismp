package service.impl;

import dao.OrderRecordMapper;
import entity.OrderRecord;
import org.springframework.stereotype.Service;
import service.orderRecordService;

import javax.annotation.Resource;

/**
 * Created by Ridiculous on 2016/6/6.
 */
@Service
public class orderRecordServiceImpl implements orderRecordService {
    @Resource
    private OrderRecordMapper mapper;

    public int addOrderRecord(OrderRecord orderRecord) {
        return mapper.insert(orderRecord);
    }
}
