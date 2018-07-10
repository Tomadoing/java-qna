package codesquad.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date time;

    @Column(length = 30, nullable = false)
    private String writer;

    @Column(length = 30, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String contents;

    public Question() {
        this.time = new Date();
    }

    public Question(String writer, String title, String contents, Date time) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.time = new Date();
    }

    public Question modify(Question q) {
        if(this.id.equals(q.id))
            throw new IllegalArgumentException("아이디가 달라용");
        this.setWriter(q.writer);
        this.setTitle(q.title);
        this.setContents(q.contents);

        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
