package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Comment> getAllComment() {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT a FROM Comment a", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(int id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public void edit(Comment comment) {
        entityManager.merge(comment);
    }
}
