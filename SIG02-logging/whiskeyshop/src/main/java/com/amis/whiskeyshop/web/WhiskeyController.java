package com.amis.whiskeyshop.web;

import com.amis.whiskeyshop.domain.Whiskey;
import com.amis.whiskeyshop.service.WhiskeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskeyController {

    @Autowired
    private WhiskeyService whiskeyService;

    @GetMapping("/whiskeys")
    public List<Whiskey> getAllWhiskey() {
        return whiskeyService.getAllWhiskeys();
    }

    @GetMapping("/whiskeys/{id}")
    public Whiskey getWhiskey(@PathVariable String id){
        return whiskeyService.getWhiskey(id);
    }

    @PostMapping("/whiskeys")
    public void addWhiskey(@RequestBody Whiskey whiskey) {
        whiskeyService.addWhiskey(whiskey);
    }

    @PutMapping("/whiskeys/{id}")
    public void updateWhiskey(@PathVariable String id, @RequestBody Whiskey whiskey) {
        whiskeyService.updateWhiskey(id, whiskey);
    }

    @DeleteMapping("/whiskeys/{id}")
    public void deleteWhiskey(@PathVariable String id) {
        whiskeyService.deleteWhiskey(id);
    }

}
