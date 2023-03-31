package br.com.capiroto.plangapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PLangController {

    @Autowired
    private PLangRepository pLangRepository;
    
    @GetMapping(value="/fav-p-lang")
    public String getFavoriteLanguage(){
        return "Anything but Java";
    }

    @GetMapping(value="/p-langs")
    public List<PLang> getPLangs(){
        return pLangRepository.findByOrderByRanking();
    }

    @GetMapping(value="/p-langs/{id}")
    public PLang getPLangById(@PathVariable String id){
        return pLangRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value="/p-langs")
    public ResponseEntity<PLang> addPlang(@RequestBody PLang pLang){
        return new ResponseEntity<>(pLangRepository.save(pLang), HttpStatus.CREATED);
    }

    @PutMapping(value="/p-langs/{id}")
    public PLang updatePlangById(@PathVariable String id, @RequestBody PLang pLang){
        if(!pLangRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        pLang.setId(id);
        return pLangRepository.save(pLang);
    }

    @DeleteMapping(value="/p-langs/{id}")
    public boolean deletePLangById(@PathVariable String id){
        if(!pLangRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        pLangRepository.deleteById(id);
        return true;
    }

    
}
