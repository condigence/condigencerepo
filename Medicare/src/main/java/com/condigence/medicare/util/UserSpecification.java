//package com.condigence.medicare.util;
//import java.util.function.Predicate;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.Root;
//
//import org.springframework.data.jpa.domain.Specification;
//
//import com.condigence.medicare.model.SearchCriteria;
//import com.condigence.medicare.model.User;
//
//public class UserSpecification implements Specification<User> {
//	     
//	private SearchCriteria criteria;     
//	@Override
//	    public Predicate toPredicate      (
//	Root<User> root, CriteriaQuery<?>query,
//	CriteriaBuilder builder)
//	{
//  
//        if (criteria.getOperation().equalsIgnoreCase(">")) {
//            return builder.greaterThanOrEqualTo(
//              root.<String> get(criteria.getKey()), criteria.getValue().toString());
//        } 
//        else if (criteria.getOperation().equalsIgnoreCase("<")) {
//            return builder.lessThanOrEqualTo(
//              root.<String> get(criteria.getKey()), criteria.getValue().toString());
//        } 
//        else if (criteria.getOperation().equalsIgnoreCase(":")) {
//            if (root.get(criteria.getKey()).getJavaType() == String.class) {
//                return builder.like(
//                  root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
//            } else {
//                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
//            }
//        }
//        return null;
//    }
//}