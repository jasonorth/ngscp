package services;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Bar;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BarServiceImpl implements BarService {

    private List<Bar> bars = new ArrayList<>();
    
    @Override
    public void addBar(Bar bar) {
    	bar.id = new Random().nextLong();
        bars.add(bar);
    }

    @Override
    public List<Bar> getAllBars() {
        return bars;
    }

}