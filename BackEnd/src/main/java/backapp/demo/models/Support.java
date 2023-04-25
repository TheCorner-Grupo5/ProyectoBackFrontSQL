package backapp.demo.models;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter

public class Support {
	private String url;
    private String text;

    public Support(String url, String text) {
        this.url = url;
        this.text = text;
    }
	
}
