package at.muellner.examples.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import at.muellner.examples.webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>
{
}
