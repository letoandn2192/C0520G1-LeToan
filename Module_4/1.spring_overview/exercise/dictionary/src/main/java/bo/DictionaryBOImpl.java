package bo;

import dao.DictionaryDAO;
import dao.DictionaryDAOImpl;

public class DictionaryBOImpl implements DictionaryBO {
    private DictionaryDAO dictionaryDAO = new DictionaryDAOImpl();

    @Override
    public String search(String search) {
        return dictionaryDAO.search(search);
    }
}
