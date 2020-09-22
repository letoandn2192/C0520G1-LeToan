package vn.codegym.repository;

import vn.codegym.model.Setting;

import java.util.List;

public interface SettingRepository {
    Setting getSetting();

    void edit(Setting setting);

    List<String> getLanguageList();

    List<Integer> getPageSizeList();
}
