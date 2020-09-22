package vn.codegym.service;

import vn.codegym.model.Setting;

import java.util.List;

public interface SettingService {
    Setting getSetting();

    void edit(Setting setting);

    List<String> getLanguageList();

    List<Integer> getPageSizeList();
}
