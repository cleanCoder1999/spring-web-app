package at.muellner.examples.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import at.muellner.examples.webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
}
