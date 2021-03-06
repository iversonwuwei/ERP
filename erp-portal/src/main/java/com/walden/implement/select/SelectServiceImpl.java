package com.walden.implement.select;

import com.walden.dao.SexDao;
import com.walden.service.database.ISelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by walden on 16/6/13.
 */
@Service
@Qualifier(value = "sexSelectService")
public class SelectServiceImpl<SexEntity> implements ISelectService<SexEntity> {

    @Autowired
    private SexDao sexDao;

    public List<SexEntity> selectAll() {
        return (List<SexEntity>) sexDao.selectAll();
    }

    public List<SexEntity> selectBy(String t) {
        return (List<SexEntity>) sexDao.getSexByType(t);
    }
}
