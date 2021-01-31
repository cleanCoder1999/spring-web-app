package at.muellner.examples.webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "PUBLISHER")
public class Publisher
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;

    @OneToMany
    @JoinColumn(name = "PUBLISHER_ID")
    private Set<Book> books = new HashSet<>();

    public Publisher()
    {
    }

    public Long getId()
    {
        return id;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(final Set<Book> books)
    {
        this.books = books;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1(final String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(final String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(final String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(final String zip)
    {
        this.zip = zip;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("name", name)
            .append("addressLine1", addressLine1)
            .append("city", city)
            .append("state", state)
            .append("zip", zip)
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

        final Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }
}
