package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.codegym.model.Comment;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
    @Override
    public List<Comment> getAllComment() {
        Session session = null;
        List<Comment> commentList = null;
        try {
            session = DBConnection.getSessionFactory().openSession();
            commentList = session.createQuery("FROM Comment").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return commentList;
    }

    @Override
    public Comment findById(int id) {
        Session session = null;
        Comment comment = null;
        try {
            session = DBConnection.getSessionFactory().openSession();
            String queryStr = "SELECT c FROM Comment AS c WHERE c.id = :id";
            TypedQuery<Comment> query = DBConnection.getEntityManager().createQuery(queryStr, Comment.class);
            query.setParameter("id", id);
            comment = query.getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return comment;
    }

    @Override
    public void save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = DBConnection.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(comment);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void edit(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = DBConnection.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String queryString = "UPDATE Comment SET commentLike = :commentLike WHERE id = :id";
            Query query = session.createQuery(queryString);
            query.setParameter("commentLike", comment.getCommentLike());
            query.setParameter("id", comment.getId());
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
