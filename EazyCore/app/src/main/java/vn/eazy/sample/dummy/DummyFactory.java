package vn.eazy.sample.dummy;

import java.util.ArrayList;
import java.util.List;

import vn.eazy.sample.model.Data;

/**
 * Created by Harry on 2/7/17.
 */

public class DummyFactory {
    public static List<Data> generateData() {
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            datas.add(new Data("Harry " + i));
        }
        return datas;
    }
}
