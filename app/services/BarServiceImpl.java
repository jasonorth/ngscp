package services;


import models.Bar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.Logger;

import java.util.List;
import java.util.ArrayList;

@Service
@Transactional
public class BarServiceImpl implements BarService {

    private List<Bar> bars = new ArrayList<>();
    
    @Override
    public void addBar(Bar bar) {
        bars.add(bar);
    }

    @Override
    public List<Bar> getAllBars() {
        return bars;
    }

}