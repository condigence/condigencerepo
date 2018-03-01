package com.digitmarket.defaultstore.providerservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.providerservice.model.ServiceReviewComments;


@Repository("serviceReviewCommentsRepository")
public interface ServiceReviewCommentsRepository extends CrudRepository<ServiceReviewComments, UUID> {

	public List<ServiceReviewComments> findAllByOrderByReviewCommentsIdDesc();
}
