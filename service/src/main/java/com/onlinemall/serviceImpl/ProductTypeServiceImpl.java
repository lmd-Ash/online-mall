package com.onlinemall.serviceImpl;

import com.onlinemall.mapper.ProductTypeMapper;
import com.onlinemall.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;
}
