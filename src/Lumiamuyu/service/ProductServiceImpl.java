package Lumiamuyu.service;

import Lumiamuyu.dao.IProductDao;
import Lumiamuyu.dao.ProductDaoImpl;
import Lumiamuyu.pojo.Product;
import Lumiamuyu.pojo.ResultData;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    private IProductDao dao = new ProductDaoImpl();
    @Override
    public List<Product> getLists() {
        return dao.getLists();
    }

    @Override
    public ResultData getLists(int pageNo, int pageSize) {
        ResultData data = new ResultData(pageNo,pageSize,dao.getCount());
        data.setLists(dao.getLists(pageNo,pageSize));
        return data;
    }

    @Override
    public int add(Product product) {
        return dao.add(product);
    }

    @Override
    public int dele(int id) {
        return dao.dele(id);
    }

    @Override
    public Product getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public int update(Product product) {
        return dao.update(product);
    }

    @Override
    public List<Product> getResult(String text) {
        return dao.getResult(text);
    }
}
