package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Setting;
import vn.codegym.repository.SettingRepository;
import vn.codegym.repository.SettingRepositoryImpl;
import vn.codegym.service.SettingService;

import java.util.List;
@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    private SettingRepository settingRepository;

    @Override
    public Setting getSetting() {
        return settingRepository.getSetting();
    }

    @Override
    public void edit(Setting setting) {
        settingRepository.edit(setting);
    }

    @Override
    public List<String> getLanguageList() {
        return settingRepository.getLanguageList();
    }

    @Override
    public List<Integer> getPageSizeList() {
        return settingRepository.getPageSizeList();
    }
}
