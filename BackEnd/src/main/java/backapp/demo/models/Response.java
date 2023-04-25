package backapp.demo.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;
    private Support support;

    public Response(int page, int per_page, int total, int total_pages) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
    }
}
