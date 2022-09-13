package service;

import dao.SanPhamDao;
import dto.SanPham;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-12-2022 23:24
 **/
public interface SanPhamService {
    SanPham them(SanPham input);
    List<SanPhamDao> hienThi();

}
