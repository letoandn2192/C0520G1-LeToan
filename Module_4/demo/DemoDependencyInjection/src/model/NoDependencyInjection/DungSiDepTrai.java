package model.NoDependencyInjection;

import Repository.DungSi;

public class DungSiDepTrai implements DungSi {
    private NhiemVuDietRong nhiemvu;


    public DungSiDepTrai() {
        this.nhiemvu = new NhiemVuDietRong();
    }


    @Override
    public String thucHienNhiemVu() {
        return nhiemvu.thucHien();
    }

}