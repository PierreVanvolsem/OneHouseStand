package be.hubrussel.dao;

import be.hubrussel.domain.Mat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("matDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MatHybernateDao implements MatDao {
    private SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Mat addMat(Mat m) {
        currentSession().save(m);
        return m;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateMat(Mat m) {
        currentSession().update(m);
    }

    public Mat getMatById(int id) {
        return (Mat) currentSession().createQuery("from Mat where id = " + id).uniqueResult();
    }
}


