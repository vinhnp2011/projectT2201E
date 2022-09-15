package mapper;

import dao.SanPhamDao;
import dto.SanPham;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 23:25
 **/
public class SanPhamMapper {

    public SanPham mapEntityToDto(SanPhamDao sanPhamDao) {
        SanPham sanPham = new SanPham();
        sanPham.setMaNhomHang(sanPhamDao.getMaNhomHang());
        sanPham.setMaVach(sanPhamDao.getMaVach());
        sanPham.setMaSpham(sanPhamDao.getMaSpham());
        sanPham.setMaSphamStr(sanPhamDao.getMaSphamStr());
        sanPham.setTenSpham(sanPhamDao.getTenSpham());
        sanPham.setMoTa(sanPhamDao.getMoTa());
        sanPham.setGiaNhap(sanPhamDao.getGiaNhap());
        sanPham.setGiaBan(sanPhamDao.getGiaBan());
        sanPham.setVat(sanPhamDao.getVat());
        return sanPham;

    }

    public List<SanPham> mapEntitiesToDtos(List<SanPhamDao> sanPhamDaos) {
        List<SanPham> sanPhamlist = new ArrayList<>();
        for (SanPhamDao sanPhamDao : sanPhamDaos) {
            sanPhamlist.add(convertFromSanPhamDao(sanPhamDao));
        }
        return sanPhamlist;

    }

    private SanPham convertFromSanPhamDao(SanPhamDao sanPhamDao) {
        SanPham sanPham = new SanPham();
        sanPham.setMaNhomHang(sanPhamDao.getMaNhomHang());
        sanPham.setMaVach(sanPhamDao.getMaVach());
        sanPham.setMaSpham(sanPhamDao.getMaSpham());
        sanPham.setMaSphamStr(sanPhamDao.getMaSphamStr());
        sanPham.setTenSpham(sanPhamDao.getTenSpham());
        sanPham.setMoTa(sanPhamDao.getMoTa());
        sanPham.setGiaNhap(sanPhamDao.getGiaNhap());
        sanPham.setGiaBan(sanPhamDao.getGiaBan());
        sanPham.setVat(sanPhamDao.getVat());
        return sanPham;
    }


    public SanPhamDao mapDtoToEntity(SanPham sanPham) {
        SanPhamDao sanPhamDao = new SanPhamDao();
        sanPhamDao.setMaNhomHang(sanPham.getMaNhomHang());
        sanPhamDao.setMaVach(sanPham.getMaVach());
        sanPhamDao.setMaSpham(sanPham.getMaSpham());
        sanPhamDao.setMaSphamStr(sanPham.getMaSphamStr());
        sanPhamDao.setTenSpham(sanPham.getTenSpham());
        sanPhamDao.setMoTa(sanPham.getMoTa());
        sanPhamDao.setGiaNhap(sanPham.getGiaNhap());
        sanPhamDao.setGiaBan(sanPham.getGiaBan());
        sanPhamDao.setVat(sanPham.getVat());
        return sanPhamDao;

    }

    public List<SanPhamDao> mapDtosToEntities(List<SanPham> sanPhamList) {
        List<SanPhamDao> sanPhamDaolist = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            sanPhamDaolist.add(convertFromSanPham(sanPham));
        }
        return sanPhamDaolist;

    }

    private SanPhamDao convertFromSanPham(SanPham sanPham) {
        SanPhamDao sanPhamDao = new SanPhamDao();
        sanPhamDao.setMaNhomHang(sanPham.getMaNhomHang());
        sanPhamDao.setMaVach(sanPham.getMaVach());
        sanPhamDao.setMaSpham(sanPham.getMaSpham());
        sanPhamDao.setMaSphamStr(sanPham.getMaSphamStr());
        sanPhamDao.setTenSpham(sanPham.getTenSpham());
        sanPhamDao.setMoTa(sanPham.getMoTa());
        sanPhamDao.setGiaNhap(sanPham.getGiaNhap());
        sanPhamDao.setGiaBan(sanPham.getGiaBan());
        sanPhamDao.setVat(sanPham.getVat());
        return sanPhamDao;
    }


}
