package com.amis.whiskeyshop.service;

import com.amis.whiskeyshop.domain.Whiskey;
import com.amis.whiskeyshop.domain.WhiskeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class WhiskeyService {

    private static final Logger LOG = LoggerFactory.getLogger(WhiskeyService.class);
    private static final Random RAND = new Random();
    private static final float DB_FAILURE_CHANCE = 0.10f;

    @Autowired
    private WhiskeyRepository whiskeyRepository;

    public List<Whiskey> getAllWhiskeys() {
        List<Whiskey> whiskeys = new ArrayList<>();
        if (RAND.nextFloat() > DB_FAILURE_CHANCE) {
            whiskeyRepository.findAll().forEach(whiskeys::add);
            LOG.info("All whiskeys retrieved.");
        } else {
            LOG.error("An error occurred when retrieving all whiskey's");
        }
        return whiskeys;
    }

    public Whiskey getWhiskey(String id) {
        Whiskey result = new Whiskey();
        if (RAND.nextFloat() > DB_FAILURE_CHANCE) {
            whiskeyRepository.findById(id);
            LOG.info("Got whiskey {}", id);
        } else {
            LOG.error("An error occurred when retrieving whiskey {}", id);
        }
        return result;
    }

    public void addWhiskey(Whiskey whiskey) {
        if (RAND.nextFloat() > DB_FAILURE_CHANCE) {
            whiskeyRepository.save(whiskey);
            LOG.info("Added new whiskey {}", whiskey.getId());
        } else {
            LOG.error("An error occurred when adding whiskey {}", whiskey.getId());
        }
    }

    public void updateWhiskey(String id, Whiskey whiskey) {
        if (RAND.nextFloat() > DB_FAILURE_CHANCE) {
            whiskeyRepository.save(whiskey);
            LOG.info("Updated whiskey {}", id);
        } else {
            LOG.error("An error occurred when updating whiskey {}", id);
        }
    }

    public void deleteWhiskey(String id) {
        if (RAND.nextFloat() > DB_FAILURE_CHANCE) {
            whiskeyRepository.deleteById(id);
            LOG.info("Deleted whiskey {}", id);
        } else {
            LOG.error("An error occurred when deleting whiskey {}", id);
        }
    }

}
