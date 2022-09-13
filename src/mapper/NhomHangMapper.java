package mapper;
import java.util.ArrayList;

import dao.NhomHangDao;
import dto.NhomHang;

import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 23:25
 **/
public class NhomHangMapper {
    public NhomHang mapEntityToDto(NhomHangDao nhomHangDao){
        NhomHang nhomHang = new NhomHang();
        nhomHang.setMaNhomHang(nhomHangDao.getMaNhomHang());
        nhomHang.setTenNhomHang(nhomHangDao.getTenNhomHang());
        nhomHang.setVat(nhomHangDao.getVat());
        return nhomHang;
    }

    public List<NhomHang> mapEntitiesToDtos(List<NhomHangDao> nhomHangDaos){
        List<NhomHang> nhomHanglist=new ArrayList<>();
        for (NhomHangDao nhomHangDao :nhomHangDaos) {
        	nhomHanglist.add(convertFromNhomHangDao(nhomHangDao));
        }
        return nhomHanglist;

    }

    private NhomHang convertFromNhomHangDao(NhomHangDao nhomHangDao) {
        NhomHang nhomHang = new NhomHang();
        nhomHang.setMaNhomHang(nhomHangDao.getMaNhomHang());
        nhomHang.setTenNhomHang(nhomHangDao.getTenNhomHang());
        nhomHang.setVat(nhomHangDao.getVat());
        return nhomHang;
    }

    public NhomHangDao mapDtoToEntity(NhomHang nhomHang){
        NhomHangDao nhomHangDao = new NhomHangDao();
        nhomHangDao.setMaNhomHang(nhomHang.getMaNhomHang());
        nhomHangDao.setTenNhomHang(nhomHang.getTenNhomHang());
        nhomHangDao.setVat(nhomHang.getVat());
        return nhomHangDao;
    }

    public List<NhomHangDao> mapDtosToEntities(List<NhomHang> nhomHangDaos){
        List<NhomHangDao> nhomHangDaolist=new ArrayList<>();
        for (NhomHang nhomHang :nhomHangDaos) {
        	nhomHangDaolist.add(convertFromNhomHang(nhomHang));
        }
        return nhomHangDaolist;
    }

    private NhomHangDao convertFromNhomHang(NhomHang nhomHang) {
        NhomHangDao nhomHangDao = new NhomHangDao();
        nhomHangDao.setMaNhomHang(nhomHang.getMaNhomHang());
        nhomHangDao.setTenNhomHang(nhomHang.getTenNhomHang());
        nhomHangDao.setVat(nhomHang.getVat());
        return nhomHangDao;
    }
}
