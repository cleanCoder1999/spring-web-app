package at.muellner.examples.webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "BOOK")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(
        name = "AUTHOR_BOOK",
        joinColumns = @JoinColumn(name = "BOOK_ID"),
        inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    private Publisher publisher;

    public Book()
    {
    }

    public Book(final String title, final String isbn)
    {
        this.title = title;
        this.isbn = isbn;
    }

    public Publisher getPublisher()
    {
        return publisher;
    }

    public void setPublisher(final Publisher publisher)
    {
        this.publisher = publisher;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(final String isbn)
    {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(final Set<Author> authors)
    {
        this.authors = authors;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("title", title)
            .append("isbn", isbn)
            .toString();
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        final Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }
}
