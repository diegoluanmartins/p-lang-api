package br.com.capiroto.plangapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PLangController {

    @Autowired
    private PLangRepository pLangRepository;
    
    @GetMapping(value="/fav-p-lang")
    public String getFavoriteLanguage(){
        return "Anything but Java";
    }

    @GetMapping(value="p-langs")
    public List<PLang> getPLangs(){
        return pLangRepository.findAll();
    }

    @PostMapping(value="p-langs")
    public PLang addPlang(@RequestBody PLang pLang){
        return pLangRepository.save(pLang);
    }

    
}
