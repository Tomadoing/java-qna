package codesquad.domain;

import codesquad.exception.AuthorizationException;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date time;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private User writer;

    @Column(length = 30, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String contents;

    public Question() {
        this.time = new Date();
    }

    public Question(User writer, String title, String contents, Date time) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.time = new Date();
    }

    public Question modify(Question q) {
        validateId(q);
        this.setWriter(q.writer);
        this.setTitle(q.title);
        this.setContents(q.contents);

        return this;
    }

    private void validateId(Question q) {
        if(!this.id.equals(q.id))
            throw new IllegalArgumentException("아이디가 달라용");
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

    public User getWriter() {
        return this.writer;
    }

    public void setWriter(User writer) {
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

    public void validateWriter(User user) {
        if (!this.getWriter().getName().equals(user.getName())) {
            throw new AuthorizationException();
        }
    }
}
