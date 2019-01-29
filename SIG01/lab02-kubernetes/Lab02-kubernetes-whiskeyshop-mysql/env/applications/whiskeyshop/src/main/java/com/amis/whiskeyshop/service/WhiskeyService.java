package com.amis.whiskeyshop.service;

import com.amis.whiskeyshop.domain.Whiskey;
import com.amis.whiskeyshop.domain.WhiskeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WhiskeyService {

    @Autowired
    private WhiskeyRepository whiskeyRepository;

    public List<Whiskey> getAllWhiskeys() {
        List<Whiskey> whiskeys = new  ArrayList<>();
        whiskeyRepository.findAll().forEach(whiskeys::add);
        return whiskeys;
    }

    public Whiskey getWhiskey(String id) {
        return whiskeyRepository.findById(id).orElseGet(Whiskey::new);
    }

    public void addWhiskey(Whiskey whiskey) {
        whiskeyRepository.save(whiskey);
    }

    public void updateWhiskey(String id, Whiskey whiskey) {
        whiskeyRepository.save(whiskey);
    }

    public void deleteWhiskey(String id) {
        whiskeyRepository.deleteById(id);
    }

}
