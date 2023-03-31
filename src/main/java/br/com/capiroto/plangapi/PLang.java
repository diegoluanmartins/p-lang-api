package br.com.capiroto.plangapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("mainPLangs")
public class PLang {

    @Id
    private String id;

    private String title;
    private String image;
    private int ranking;
    
    public PLang() {
    }
    
    public PLang(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getTitle() {
        return title;
    }
    
    public String getImage() {
        return image;
    }
    
    public int getRanking() {
        return ranking;
    }

    public String getId() {
        return id;
    }
    
}
