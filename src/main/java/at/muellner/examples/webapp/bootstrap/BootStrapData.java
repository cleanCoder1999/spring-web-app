package at.muellner.examples.webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import at.muellner.examples.webapp.domain.Author;
import at.muellner.examples.webapp.domain.Book;
import at.muellner.examples.webapp.domain.Publisher;
import at.muellner.examples.webapp.repository.AuthorRepository;
import at.muellner.examples.webapp.repository.BookRepository;
import at.muellner.examples.webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner
{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(
        final AuthorRepository authorRepository,
        final BookRepository bookRepository,
        final PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(final String... args) throws Exception
    {
        Author juls = new Author("Juls", "Roy");
        Book tdd = new Book("Test Driven Development", "1234L");
        juls.getBooks().add(tdd);
        tdd.getAuthors().add(juls);


        authorRepository.save(juls);
        bookRepository.save(tdd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "12146544654");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher ieee = new Publisher();
        ieee.setName("IEEE Association");
        ieee.setAddressLine1("Beverly Hills Street 1");
        ieee.setCity("New York City");
        ieee.setState("New York County");
        ieee.setZip("12345");

        tdd.setPublisher(ieee);
        ieee.getBooks().add(tdd);

        noEJB.setPublisher(ieee);
        ieee.getBooks().add(noEJB);

        publisherRepository.save(ieee);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + ieee.getBooks().size());

    }
}
